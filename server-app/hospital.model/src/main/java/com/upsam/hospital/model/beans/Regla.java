package com.upsam.hospital.model.beans;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import com.upsam.hospital.model.enums.TipoRegla;

// TODO: Auto-generated Javadoc
/**
 * The Class Regla.
 */
@Entity
@Table(name = "REGLA")
public class Regla implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -675589228240481204L;

	/** The campos infos. */
	@OneToMany(mappedBy = "regla", orphanRemoval = true)
	@Cascade(value = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CampoInfo> camposInfos;

	/** The campos rellenados. */
	@OneToMany(mappedBy = "regla", orphanRemoval = true)
	@Cascade(value = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CampoRellenado> camposRellenados;

	/** The campos sugeridos. */
	@OneToMany(mappedBy = "regla", orphanRemoval = true)
	@Cascade(value = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CampoSugerido> camposSugeridos;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_REGLA")
	private Integer id;

	/** The mensaje. */
	@Basic
	@Column(name = "MENSAJE")
	private String mensaje;

	/** The tipo regla. */
	@Basic
	@Column(name = "TIPO_REGLA")
	private TipoRegla tipoRegla;

	/** The titulo. */
	@Basic
	@Column(name = "TITULO")
	private String titulo;

	/**
	 * Adds the campo info.
	 * 
	 * @param campoInfo
	 *            the campo info
	 */
	public void addCampoInfo(CampoInfo campoInfo) {
		if (this.getCamposInfos() == null) {
			this.setCamposInfos(new ArrayList<CampoInfo>());
		}
		this.getCamposInfos().add(campoInfo);
	}

	/**
	 * Adds the campo rellenado.
	 * 
	 * @param campoRellenado
	 *            the campo rellenado
	 */
	public void addCampoRellenado(CampoRellenado campoRellenado) {
		if (this.getCamposRellenados() == null) {
			this.setCamposRellenados(new ArrayList<CampoRellenado>());
		}
		this.getCamposRellenados().add(campoRellenado);
	}

	/**
	 * Adds the campo sugerido.
	 * 
	 * @param campoSugerido
	 *            the campo sugerido
	 */
	public void addCampoSugerido(CampoSugerido campoSugerido) {
		if (this.getCamposSugeridos() == null) {
			this.setCamposSugeridos(new ArrayList<CampoSugerido>());
		}
		this.getCamposSugeridos().add(campoSugerido);
	}

	/**
	 * Gets the campos infos.
	 * 
	 * @return the campos infos
	 */
	public List<CampoInfo> getCamposInfos() {
		return camposInfos;
	}

	/**
	 * Gets the campos rellenados.
	 * 
	 * @return the campos rellenados
	 */
	public List<CampoRellenado> getCamposRellenados() {
		return camposRellenados;
	}

	/**
	 * Gets the campos sugeridos.
	 * 
	 * @return the campos sugeridos
	 */
	public List<CampoSugerido> getCamposSugeridos() {
		return camposSugeridos;
	}

	/**
	 * Gets the id.
	 * 
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Gets the mensaje.
	 * 
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Gets the tipo regla.
	 * 
	 * @return the tipo regla
	 */
	public TipoRegla getTipoRegla() {
		return tipoRegla;
	}

	/**
	 * Gets the titulo.
	 * 
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Sets the campos infos.
	 * 
	 * @param camposInfos
	 *            the new campos infos
	 */
	public void setCamposInfos(List<CampoInfo> camposInfos) {
		this.camposInfos = camposInfos;
	}

	/**
	 * Sets the campos rellenados.
	 * 
	 * @param camposRellenados
	 *            the new campos rellenados
	 */
	public void setCamposRellenados(List<CampoRellenado> camposRellenados) {
		this.camposRellenados = camposRellenados;
	}

	/**
	 * Sets the campos sugeridos.
	 * 
	 * @param camposSugeridos
	 *            the new campos sugeridos
	 */
	public void setCamposSugeridos(List<CampoSugerido> camposSugeridos) {
		this.camposSugeridos = camposSugeridos;
	}

	/**
	 * Sets the id.
	 * 
	 * @param id
	 *            the new id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Sets the mensaje.
	 * 
	 * @param mensaje
	 *            the new mensaje
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Sets the tipo regla.
	 * 
	 * @param tipoRegla
	 *            the new tipo regla
	 */
	public void setTipoRegla(TipoRegla tipoRegla) {
		this.tipoRegla = tipoRegla;
	}

	/**
	 * Sets the titulo.
	 * 
	 * @param titulo
	 *            the new titulo
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}
