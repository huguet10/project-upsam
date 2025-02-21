var sugerencia = {
	'formatForm' : function(regla) {
		sugerencia.disableOperation(true);
		//$("#form-operacion").hide();

		$("#valor").keyup(function() {
			$("#tree").fancytree('getTree').getActiveNode().data.valor = $(this).val();
		});
		$("#operacion").change(function() {
			var operacion = $("#operacion :selected").val();
			if (operacion != "-1"){
				$("#tree span.fancytree-active").css("background-color", "rgb(255, 145, 145)");
				$("#valor").val("");
				$("#tree").fancytree('getTree').getActiveNode().data.operacion = $("#operacion :selected").val();
			}
			else{
				$("#tree span.fancytree-active").css("background-color", "white");
			}
		});

		generic.get("sugerencia/paginas", null, function(paginas) {
			var tree = [];
			var i;

			i = 0;
			paginas.forEach(function(pagina) {
				tree.push({
					title : pagina.nombre,
					folder : true,
					children : []
				});
				if (pagina.camposDTO != null){
					pagina.camposDTO.forEach(function(campoDTO) {
						var node = {
							title : campoDTO.nombre + " [" + campoDTO.minValue + ", " + campoDTO.maxValue + "]",
							key : campoDTO.id,
						};
						if (regla != null) {
							regla.camposInfosDTO.forEach(function(campoInfo) {
								if (node.key == campoInfo.idCampo) {
									node.id = campoInfo.id;
									node.operacion = campoInfo.operacion;
									node.valor = campoInfo.valor;
								}
							});
						}
						tree[i].children.push(node);
					});
				}
				i++;
			});

			$("#tree").fancytree({
				source : tree,
				icons : false,
				checkbox : false,
				selectMode : 1,
				activate: function(event, node) {
					if (!node.node.isActive() || node.node.hasChildren()) {
						sugerencia.disableOperation(true);
						//$("#form-operacion").hide();
					}
					else {
						sugerencia.disableOperation(false);
						//$("#form-operacion").show();
						if (node.node.data.operacion != null && node.node.data.valor != null) {
							$("#valor").val(node.node.data.valor);
							var byDefault = node.node.data.operacion;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
						else {
							$("#valor").val(null);
							var byDefault = -1;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
					}
			    },
				select : function(flag, node) {
					if (!node.node.isSelected() || node.node.hasChildren()) {
						sugerencia.disableOperation(true);
						//$("#form-operacion").hide();
					}
					else {
						sugerencia.disableOperation(false);
						//$("#form-operacion").show();
						if (node.node.data.operacion != null && node.node.data.valor != null) {
							$("#valor").val(node.node.data.valor);
							var byDefault = node.node.data.operacion;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
						else {
							$("#valor").val(null);
							var byDefault = -1;
							$("#operacion option").each(function() {
								var $this = $(this);
								if ($this.val() == byDefault) {
									$this.prop('selected', true);
									return false;
								}
							});
						}
					}
				}
			});
			
			if (regla != null){
				$("#tree").fancytree("getRootNode").visit(function(node){
			        node.setExpanded(true);
			      });
				
		    	$('input[id=id]').val(regla.id);
				$('#mensaje').val(regla.mensaje);
				$('#titulo').val(regla.titulo);
				if (regla.camposInfosDTO != null && regla.camposInfosDTO.length > 0){
					for (var i = 0; i < regla.camposInfosDTO.length; i++){
						var node = $("#tree").fancytree("getTree").getNodeByKey(regla.camposInfosDTO[i].idCampo);
						var parentNode = node.parent;
						$( "span:contains('" + parentNode.title + "')" ).parent().find("ul > li > span:contains('" + node.title + "')").css("background-color", "rgb(255, 145, 145)");
					}
				}
		    }
		});
	},
	'disableOperation' : function(disable){
		if (disable){
			$("div#form-operacion label").addClass("disableLabel");
			$("div#form-operacion select").attr('disabled', 'disabled');
			//$("div#form-operacion select").addClass("disableSelect");
			$("div#form-operacion input").attr('disabled', 'disabled');
		}
		else{
			$("div#form-operacion label").removeClass("disableLabel");
			//$("div#form-operacion select").removeClass("disableSelect");
			$("div#form-operacion select").removeAttr('disabled');
			$("div#form-operacion input").removeAttr('disabled');
		}
	},
	'getParams' : function() {
		var id = $("#id").val();
		var titulo = $("#titulo").val();
		var mensaje = $("#mensaje").val();
		var camposInfo = [];
		var nodesInfo = $("#tree").fancytree('getTree');
		if (nodesInfo && nodesInfo != null && nodesInfo.rootNode  && nodesInfo.rootNode != null && nodesInfo.rootNode.children && nodesInfo.rootNode.children != null){
			nodesInfo.rootNode.children.forEach(function(nodeParent) {
				if (nodeParent && nodeParent != null && nodeParent.children && nodeParent.children != null){
					nodeParent.children.forEach(function(node) {
						if (node.data.operacion != null && node.data.valor != null) {
							camposInfo.push({
								idCampo : node.key,
								operacion : node.data.operacion,
								valor : node.data.valor,
								id : node.data.id
							});
						}
					});
				}
			});
		}
		var data = {
			id : id,
			tipoRegla : 1,
			camposInfosDTO : camposInfo,
			titulo : titulo,
			mensaje : mensaje
		};
		var entity = (id != null) ? 'sugerencia/' + id : 'sugerencia';
		generic.post(entity, data, function() {
			generic.getList('sugerencia');
		});
	}
};