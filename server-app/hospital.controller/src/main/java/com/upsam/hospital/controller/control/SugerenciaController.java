package com.upsam.hospital.controller.control;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.dto.MensajeDTO;
import com.upsam.hospital.controller.dto.PaginaDTO;
import com.upsam.hospital.controller.dto.ReglaDTO;
import com.upsam.hospital.controller.dto.util.IFaqUtilDTO;
import com.upsam.hospital.controller.dto.util.IPaginaUtilDTO;
import com.upsam.hospital.controller.dto.util.IReglaUtilDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Exploracion;
import com.upsam.hospital.model.beans.Faq;
import com.upsam.hospital.model.beans.Pagina;
import com.upsam.hospital.model.beans.Regla;
import com.upsam.hospital.model.exceptions.DataBaseException;
import com.upsam.hospital.model.service.IExploracionService;
import com.upsam.hospital.model.service.IPaginaService;
import com.upsam.hospital.model.service.IReglaService;

@Controller
public class SugerenciaController {
	/** The Constant LOG. */
	private final static Log LOG = LogFactory.getLog(SugerenciaController.class);

	/** The exploracion service. */
	@Inject
	private IExploracionService exploracionService;

	/** The faq util dto. */
	@Inject
	private IFaqUtilDTO faqUtilDTO;

	/** The pagina service. */
	@Inject
	private IPaginaService paginaService;

	/** The pagina util dto. */
	@Inject
	private IPaginaUtilDTO paginaUtilDTO;

	/** The regla service. */
	@Inject
	private IReglaService reglaService;

	/** The regla util dto. */
	@Inject
	private IReglaUtilDTO reglaUtilDTO;

	/**
	 * Creates the form.
	 * 
	 * @param operacion
	 *            the operacion
	 * @param uiModel
	 *            the ui model
	 * @return the string
	 */
	@RequestMapping(value = "sugerencia/form/{operacion}", method = RequestMethod.GET, produces = "text/html")
	public String createForm(@PathVariable("operacion") String operacion, final Model uiModel) {
		uiModel.addAttribute("operacion", operacion);
		if (!operacion.equals("list")) {
			operacion = "form";
		}
		return new StringBuffer("sugerencia/").append(operacion).toString();
	}

	/**
	 * Delete.
	 * 
	 * @param id
	 *            the id
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "sugerencia/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	MensajeDTO delete(@PathVariable("id") Integer id) {
		MensajeDTO mensajeDTO;
		try {
			Regla regla = reglaService.findOne(id);
			reglaService.delete(regla);
			mensajeDTO = new MensajeDTO("Se ha eliminado la regla.", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			mensajeDTO = new MensajeDTO("Error al eliminar en base de datos", false);
		}
		return mensajeDTO;
	}

	/**
	 * Insert regla.
	 * 
	 * @param reglaDTO
	 *            the regla dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "sugerencia", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO insertRegla(@RequestBody ReglaDTO reglaDTO) {
		MensajeDTO mensajeDTO;
		try {
			Regla regla = reglaUtilDTO.toBusiness(reglaDTO);
			reglaService.save(regla);
			mensajeDTO = new MensajeDTO("Regla insertada correctamente", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			mensajeDTO = new MensajeDTO("Error al insertar en base de datos", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			mensajeDTO = new MensajeDTO("Error al convertir una regla.", false);
		}
		return mensajeDTO;
	}

	/**
	 * List all.
	 * 
	 * @return the list
	 */
	@RequestMapping(value = "sugerencia", method = RequestMethod.GET)
	public @ResponseBody
	List<ReglaDTO> listAll() {
		List<ReglaDTO> result = new ArrayList<ReglaDTO>();
		try {
			List<Regla> reglas = reglaService.retrieveReglasInfo();
			for (Regla regla : reglas) {
				result.add(reglaUtilDTO.toRestInfo(regla));
			}
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * Retrieve.
	 * 
	 * @param id
	 *            the id
	 * @return the regla dto
	 */
	@RequestMapping(value = "sugerencia/{id}", method = RequestMethod.GET)
	public @ResponseBody
	ReglaDTO retrieve(@PathVariable("id") Integer id) {
		ReglaDTO result = null;
		try {
			Regla regla = reglaService.findOne(id);
			result = reglaUtilDTO.toRest(regla);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * Retrieve faq.
	 * 
	 * @param idExploracion
	 *            the id exploracion
	 * @return the faq dto
	 */
	@RequestMapping(value = "pacientemovil/{idPaciente}/exploracion/{idExploracion}/sugerencia", method = RequestMethod.GET)
	public @ResponseBody
	FaqDTO retrieveFaq(@PathVariable("idExploracion") Integer idExploracion) {
		FaqDTO faqDTO = null;
		try {
			Exploracion exploracion = exploracionService.findOne(idExploracion);
			Faq faq = reglaService.doFaq(exploracion);
			faqDTO = faqUtilDTO.toRest(faq);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		catch (SecurityException e) {
			LOG.debug(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			LOG.debug(e.getMessage());
		}
		catch (NoSuchFieldException e) {
			LOG.debug(e.getMessage());
		}
		catch (IllegalAccessException e) {
			LOG.debug(e.getMessage());
		}
		return faqDTO;
	}

	/**
	 * Retrieve paginas.
	 * 
	 * @return the list
	 */
	@RequestMapping(value = "sugerencia/paginas", method = RequestMethod.GET)
	public @ResponseBody
	List<PaginaDTO> retrievePaginas() {
		List<PaginaDTO> result = new ArrayList<PaginaDTO>();
		try {
			List<Pagina> paginas1 = paginaService.findAll();
			List<Pagina> paginas = paginaService.retrievePaginasInfo();
			for (Pagina pagina : paginas) {
				result.add(paginaUtilDTO.toRestInfoPaginas(pagina));
			}
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
		}
		return result;
	}

	/**
	 * Udpate.
	 * 
	 * @param reglaDTO
	 *            the regla dto
	 * @return the mensaje dto
	 */
	@RequestMapping(value = "sugerencia/{id}", method = RequestMethod.POST)
	public @ResponseBody
	MensajeDTO udpate(@RequestBody ReglaDTO reglaDTO) {
		MensajeDTO mensajeDTO;
		try {
			Regla regla = reglaUtilDTO.toBusiness(reglaDTO);
			reglaService.update(regla);
			mensajeDTO = new MensajeDTO("Se ha actualizado la regla correctamente.", true);
		}
		catch (DataBaseException e) {
			LOG.debug(e.getMessage());
			mensajeDTO = new MensajeDTO("Error al actualizar en base de datos", false);
		}
		catch (TransferObjectException e) {
			LOG.debug(e.getMessage());
			mensajeDTO = new MensajeDTO("Error al convertir una regla.", false);
		}
		return mensajeDTO;
	}
}
