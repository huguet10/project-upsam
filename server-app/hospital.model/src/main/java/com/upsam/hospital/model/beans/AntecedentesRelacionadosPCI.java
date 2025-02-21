package com.upsam.hospital.model.beans;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.upsam.hospital.model.enums.AyudasMarcha;
import com.upsam.hospital.model.enums.OrtesisDiurna;
import com.upsam.hospital.model.enums.TipoPCI;

// TODO: Auto-generated Javadoc
/**
 * The Class AntecedentesPersonalesPCI.
 */
/**
 * @author dllamazares
 * 
 */
@Entity
@Table(name = "ANTECEDENTES_RELACIONADOS_PCI")
public class AntecedentesRelacionadosPCI implements IModelHospital {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 507181748565797857L;

	/** The ayudas marcha. */
	@Basic
	@Column(name = "AYUDAS_MARCHA")
	private AyudasMarcha ayudasMarcha;

	@Basic
	@Column(name = "TIPO_PCI")
	private TipoPCI tipoPCI;

	/** The deportes. */
	@Basic
	@Column(name = "DEPORTES")
	private String deportes;

	@Basic
	@Column(name = "DIAGNOSTICO_ESPECIFICAR")
	private String diagnosticoEspecificar;

	/** The dispositivo mas usado. */
	@Basic
	@Column(name = "DISPOSITIVO_MAS_USADO")
	private String dispositivoMasUsado;

	/** The equipamiento. */
	@Basic
	@Column(name = "EQUIPAMIENTO")
	private String equipamiento;

	/** The etiologia. */
	@Basic
	@Column(name = "ETIOLOGIA")
	private String etiologia;

	/** The exploracion. */
	@OneToOne
	@JoinColumn(name = "ID_EXPLORACION", unique = true)
	private Exploracion exploracion;

	@Basic
	@Column(name = "EXTERIORES")
	private String exteriores;

	/** The fisioterapia duracion. */
	@Basic
	@Column(name = "FISIOTERAPIA_DURACION")
	private String fisioterapiaDuracion;

	/** The fisioterapia sesiones. */
	@Basic
	@Column(name = "FISIOTERAPIA_SESIONES")
	private Integer fisioterapiaSesiones;

	/** The grado i. */
	@Basic
	@Column(name = "GMFCS")
	private Integer gmfcs;

	/** The hidroterapia. */
	@Basic
	@Column(name = "HIDROTERAPIA")
	private String hidroterapia;

	@Basic
	@Column(name = "OTRAS_TERAPIAS")
	private String otrasTerapias;

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_ANTECEDENTES_PERSONALES_PCI")
	private Integer id;

	/** The interiores. */
	@Basic
	@Column(name = "INTERIORES")
	private String interiores;

	/** The lg duracion. */
	@Basic
	@Column(name = "LG_DURACION")
	private String lgDuracion;

	/** The lg sesiones. */
	@Basic
	@Column(name = "LG_SESIONES")
	private Integer lgSesiones;

	/** The localizacion. */
	@Basic
	@Column(name = "LOCALIZACION")
	private String localizacion;

	/** The ortesis diurna. */
	@Basic
	@Column(name = "ORTESIS_DIURNA")
	private OrtesisDiurna ortesisDiurna;

	@Basic
	@Column(name = "OTRA_ORTESIS")
	private String otraOrtesis;

	/** The Ortesis nocturna. */
	@Basic
	@Column(name = "ORTESIS_NOCTURNA")
	private String ortesisNocturna;

	/** The otras. */
	@Basic
	@Column(name = "OTRAS")
	private String otras;

	/** The pruebas comlementarias. */
	@Basic
	@Column(name = "PRUEBAS_COMPLEMENTARIAS")
	private String pruebasComplementarias;

	/** The terapica ocupaciones duracion. */
	@Basic
	@Column(name = "TERAPIA_OCUPACIONAL_DURACION")
	private String terapiaOcupacionalDuracion;

	/** The terapica ocupaciones sesiones. */
	@Basic
	@Column(name = "TERAPIA_OCUPACIONAL_SESIONES")
	private Integer terapiaOcupacionalSesiones;

	/** The terapias habituales. */
	@Basic
	@Column(name = "TERAPIAS_HABITUALES")
	private String terapiasHabituales;

	/** The tratamiento actual. */
	@Basic
	@Column(name = "TRATAMIENTO_ACTUAL")
	private String tratamientoActual;

	/**
	 * Instantiates a new antecedentes personales pci.
	 */
	public AntecedentesRelacionadosPCI() {
		super();
	}

	/**
	 * Instantiates a new antecedentes personales pci.
	 * 
	 * @param ayudasMarcha
	 *            the ayudas marcha
	 * @param cuadriplejiaEspatica
	 *            the cuadriplejia espatica
	 * @param deportes
	 *            the deportes
	 * @param diplejiaEspatica
	 *            the diplejia espatica
	 * @param dispositivoMasUsado
	 *            the dispositivo mas usado
	 * @param equipamiento
	 *            the equipamiento
	 * @param etiologia
	 *            the etiologia
	 * @param exteriores
	 *            the exteriores
	 * @param fisioterapiaDuracion
	 *            the fisioterapia duracion
	 * @param fisioterapiaSesiones
	 *            the fisioterapia sesiones
	 * @param gradoI
	 *            the grado i
	 * @param gradoII
	 *            the grado ii
	 * @param gradoIII
	 *            the grado iii
	 * @param gradoIV
	 *            the grado iv
	 * @param gradoV
	 *            the grado v
	 * @param hidroterapia
	 *            the hidroterapia
	 * @param id
	 *            the id
	 * @param interiores
	 *            the interiores
	 * @param lgDuracion
	 *            the lg duracion
	 * @param lgSesiones
	 *            the lg sesiones
	 * @param localizacion
	 *            the localizacion
	 * @param ortesisDiurna
	 *            the ortesis diurna
	 * @param ortesisNocturna
	 *            the ortesis nocturna
	 * @param otra
	 *            the otra
	 * @param otras
	 *            the otras
	 * @param pciMixta
	 *            the pci mixta
	 * @param pruebasComlementarias
	 *            the pruebas comlementarias
	 * @param terapiaOcupacionalDuracion
	 *            the terapia ocupacional duracion
	 * @param terapiaOcupacionalSesiones
	 *            the terapia ocupacional sesiones
	 * @param terapiasHabituales
	 *            the terapias habituales
	 * @param tratamientoActual
	 *            the tratamiento actual
	 * @param triplejiaEspatica
	 *            the triplejia espatica
	 */

	public AntecedentesRelacionadosPCI(Integer id, AyudasMarcha ayudasMarcha, String deportes, String dispositivoMasUsado, String equipamiento, String etiologia, String exteriores, String fisioterapiaDuracion, Integer fisioterapiaSesiones, Integer gmfcs, String hidroterapia, String interiores, String lgDuracion, Integer lgSesiones, String localizacion, OrtesisDiurna ortesisDiurna, String otraOrtesis, String ortesisNocturna, String otras, String pruebasComplementarias, String terapiaOcupacionalDuracion, Integer terapiaOcupacionalSesiones, String terapiasHabituales, String tratamientoActual, String diagnosticoEspecificar, String otrasTerapias, TipoPCI tipoPCI) {
		super();
		this.id = id;
		this.ayudasMarcha = ayudasMarcha;
		this.deportes = deportes;
		this.diagnosticoEspecificar = diagnosticoEspecificar;
		this.dispositivoMasUsado = dispositivoMasUsado;
		this.equipamiento = equipamiento;
		this.etiologia = etiologia;
		this.exteriores = exteriores;
		this.fisioterapiaDuracion = fisioterapiaDuracion;
		this.fisioterapiaSesiones = fisioterapiaSesiones;
		this.gmfcs = gmfcs;
		this.hidroterapia = hidroterapia;
		this.interiores = interiores;
		this.lgDuracion = lgDuracion;
		this.lgSesiones = lgSesiones;
		this.localizacion = localizacion;
		this.ortesisDiurna = ortesisDiurna;
		this.otraOrtesis = otraOrtesis;
		this.ortesisNocturna = ortesisNocturna;
		this.otras = otras;
		this.otrasTerapias = otrasTerapias;
		this.pruebasComplementarias = pruebasComplementarias;
		this.terapiaOcupacionalDuracion = terapiaOcupacionalDuracion;
		this.terapiaOcupacionalSesiones = terapiaOcupacionalSesiones;
		this.terapiasHabituales = terapiasHabituales;
		this.tratamientoActual = tratamientoActual;
		this.tipoPCI = tipoPCI;
	}

	/**
	 * Gets the ayudas marcha.
	 * 
	 * @return the ayudas marcha
	 */
	public AyudasMarcha getAyudasMarcha() {
		return ayudasMarcha;
	}

	/**
	 * Gets the deportes.
	 * 
	 * @return the deportes
	 */
	public String getDeportes() {
		return deportes;
	}

	/**
	 * Gets the dispositivo mas usado.
	 * 
	 * @return the dispositivo mas usado
	 */
	public String getDispositivoMasUsado() {
		return dispositivoMasUsado;
	}

	/**
	 * Gets the equipamiento.
	 * 
	 * @return the equipamiento
	 */
	public String getEquipamiento() {
		return equipamiento;
	}

	/**
	 * Gets the etiologia.
	 * 
	 * @return the etiologia
	 */
	public String getEtiologia() {
		return etiologia;
	}

	/**
	 * Gets the exploracion.
	 * 
	 * @return the exploracion
	 */
	public Exploracion getExploracion() {
		return exploracion;
	}

	/**
	 * Gets the exteriores.
	 * 
	 * @return the exteriores
	 */
	public String getExteriores() {
		return exteriores;
	}

	/**
	 * Gets the fisioterapia duracion.
	 * 
	 * @return the fisioterapia duracion
	 */
	public String getFisioterapiaDuracion() {
		return fisioterapiaDuracion;
	}

	/**
	 * Gets the fisioterapia sesiones.
	 * 
	 * @return the fisioterapia sesiones
	 */
	public Integer getFisioterapiaSesiones() {
		return fisioterapiaSesiones;
	}

	/**
	 * Gets the grado i.
	 * 
	 * @return the grado i
	 */
	public Integer getGmfcs() {
		return gmfcs;
	}

	/**
	 * Gets the hidroterapia.
	 * 
	 * @return the hidroterapia
	 */
	public String getHidroterapia() {
		return hidroterapia;
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
	 * Gets the interiores.
	 * 
	 * @return the interiores
	 */
	public String getInteriores() {
		return interiores;
	}

	/**
	 * Gets the lg duracion.
	 * 
	 * @return the lg duracion
	 */
	public String getLgDuracion() {
		return lgDuracion;
	}

	/**
	 * Gets the lg sesiones.
	 * 
	 * @return the lg sesiones
	 */
	public Integer getLgSesiones() {
		return lgSesiones;
	}

	/**
	 * Gets the localizacion.
	 * 
	 * @return the localizacion
	 */
	public String getLocalizacion() {
		return localizacion;
	}

	/**
	 * Gets the ortesis diurna.
	 * 
	 * @return the ortesis diurna
	 */
	public OrtesisDiurna getOrtesisDiurna() {
		return ortesisDiurna;
	}

	/**
	 * Gets the ortesis nocturna.
	 * 
	 * @return the ortesis nocturna
	 */
	public String getOrtesisNocturna() {
		return ortesisNocturna;
	}

	/**
	 * Gets the otras.
	 * 
	 * @return the otras
	 */
	public String getOtras() {
		return otras;
	}

	/**
	 * Gets the pruebas comlementarias.
	 * 
	 * @return the pruebas comlementarias
	 */
	public String getPruebasComplementarias() {
		return pruebasComplementarias;
	}

	/**
	 * Gets the terapica ocupaciones duracion.
	 * 
	 * @return the terapica ocupaciones duracion
	 */
	public String getTerapiaOcupacionalDuracion() {
		return terapiaOcupacionalDuracion;
	}

	/**
	 * Gets the terapica ocupaciones sesiones.
	 * 
	 * @return the terapica ocupaciones sesiones
	 */
	public Integer getTerapiaOcupacionalSesiones() {
		return terapiaOcupacionalSesiones;
	}

	/**
	 * Gets the terapias habituales.
	 * 
	 * @return the terapias habituales
	 */
	public String getTerapiasHabituales() {
		return terapiasHabituales;
	}

	/**
	 * Gets the tratamiento actual.
	 * 
	 * @return the tratamiento actual
	 */
	public String getTratamientoActual() {
		return tratamientoActual;
	}

	/**
	 * Sets the ayudas marcha.
	 * 
	 * @param ayudasMarcha
	 *            the new ayudas marcha
	 */
	public void setAyudasMarcha(AyudasMarcha ayudasMarcha) {
		this.ayudasMarcha = ayudasMarcha;
	}

	/**
	 * Sets the deportes.
	 * 
	 * @param deportes
	 *            the new deportes
	 */
	public void setDeportes(String deportes) {
		this.deportes = deportes;
	}

	/**
	 * Sets the dispositivo mas usado.
	 * 
	 * @param dispositivoMasUsado
	 *            the new dispositivo mas usado
	 */
	public void setDispositivoMasUsado(String dispositivoMasUsado) {
		this.dispositivoMasUsado = dispositivoMasUsado;
	}

	/**
	 * Sets the equipamiento.
	 * 
	 * @param equipamiento
	 *            the new equipamiento
	 */
	public void setEquipamiento(String equipamiento) {
		this.equipamiento = equipamiento;
	}

	/**
	 * Sets the etiologia.
	 * 
	 * @param etiologia
	 *            the new etiologia
	 */
	public void setEtiologia(String etiologia) {
		this.etiologia = etiologia;
	}

	/**
	 * Sets the exploracion.
	 * 
	 * @param exploracion
	 *            the new exploracion
	 */
	public void setExploracion(Exploracion exploracion) {
		this.exploracion = exploracion;
	}

	/**
	 * Sets the exteriores.
	 * 
	 * @param exteriores
	 *            the new exteriores
	 */
	public void setExteriores(String exteriores) {
		this.exteriores = exteriores;
	}

	/**
	 * Sets the fisioterapia duracion.
	 * 
	 * @param fisioterapiaDuracion
	 *            the new fisioterapia duracion
	 */
	public void setFisioterapiaDuracion(String fisioterapiaDuracion) {
		this.fisioterapiaDuracion = fisioterapiaDuracion;
	}

	/**
	 * Sets the fisioterapia sesiones.
	 * 
	 * @param fisioterapiaSesiones
	 *            the new fisioterapia sesiones
	 */
	public void setFisioterapiaSesiones(Integer fisioterapiaSesiones) {
		this.fisioterapiaSesiones = fisioterapiaSesiones;
	}

	/**
	 * Sets the grado i.
	 * 
	 * @param gradoI
	 *            the new grado i
	 */
	public void setGmfcs(Integer gmfcs) {
		this.gmfcs = gmfcs;
	}

	/**
	 * Sets the hidroterapia.
	 * 
	 * @param hidroterapia
	 *            the new hidroterapia
	 */
	public void setHidroterapia(String hidroterapia) {
		this.hidroterapia = hidroterapia;
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
	 * Sets the interiores.
	 * 
	 * @param interiores
	 *            the new interiores
	 */
	public void setInteriores(String interiores) {
		this.interiores = interiores;
	}

	/**
	 * Sets the lg duracion.
	 * 
	 * @param lgDuracion
	 *            the new lg duracion
	 */
	public void setLgDuracion(String lgDuracion) {
		this.lgDuracion = lgDuracion;
	}

	/**
	 * Sets the lg sesiones.
	 * 
	 * @param lgSesiones
	 *            the new lg sesiones
	 */
	public void setLgSesiones(Integer lgSesiones) {
		this.lgSesiones = lgSesiones;
	}

	/**
	 * Sets the localizacion.
	 * 
	 * @param localizacion
	 *            the new localizacion
	 */
	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

	/**
	 * Sets the ortesis diurna.
	 * 
	 * @param ortesisDiurna
	 *            the new ortesis diurna
	 */
	public void setOrtesisDiurna(OrtesisDiurna ortesisDiurna) {
		this.ortesisDiurna = ortesisDiurna;
	}

	/**
	 * Sets the ortesis nocturna.
	 * 
	 * @param ortesisNocturna
	 *            the new ortesis nocturna
	 */
	public void setOrtesisNocturna(String ortesisNocturna) {
		this.ortesisNocturna = ortesisNocturna;
	}

	/**
	 * Sets the otras.
	 * 
	 * @param otras
	 *            the new otras
	 */
	public void setOtras(String otras) {
		this.otras = otras;
	}

	/**
	 * Sets the pruebas comlementarias.
	 * 
	 * @param pruebasComlementarias
	 *            the new pruebas comlementarias
	 */
	public void setPruebasComplementarias(String pruebasComlementarias) {
		this.pruebasComplementarias = pruebasComlementarias;
	}

	/**
	 * Sets the terapica ocupaciones sesiones.
	 * 
	 * @param terapiaOcupacionalSesiones
	 *            the new terapia ocupacional sesiones
	 */
	public void setTerapiaOcupacionalSesiones(Integer terapiaOcupacionalSesiones) {
		this.terapiaOcupacionalSesiones = terapiaOcupacionalSesiones;
	}

	/**
	 * Sets the terapias habituales.
	 * 
	 * @param terapiasHabituales
	 *            the new terapias habituales
	 */
	public void setTerapiasHabituales(String terapiasHabituales) {
		this.terapiasHabituales = terapiasHabituales;
	}

	/**
	 * Sets the terapica ocupaciones duracion.
	 * 
	 * @param terapiaOcupacionalDuracion
	 *            the new terapica ocupacional duracion
	 */
	public void setTerapiaOcupacionalDuracion(String terapiaOcupacionalDuracion) {
		this.terapiaOcupacionalDuracion = terapiaOcupacionalDuracion;
	}

	/**
	 * Sets the tratamiento actual.
	 * 
	 * @param tratamientoActual
	 *            the new tratamiento actual
	 */
	public void setTratamientoActual(String tratamientoActual) {
		this.tratamientoActual = tratamientoActual;
	}

	public String getDiagnosticoEspecificar() {
		return diagnosticoEspecificar;
	}

	public void setDiagnosticoEspecificar(String diagnosticoEspecificar) {
		this.diagnosticoEspecificar = diagnosticoEspecificar;
	}

	public String getOtraOrtesis() {
		return otraOrtesis;
	}

	public void setOtraOrtesis(String otraOrtesis) {
		this.otraOrtesis = otraOrtesis;
	}

	public String getOtrasTerapias() {
		return otrasTerapias;
	}

	public void setOtrasTerapias(String otrasTerapias) {
		this.otrasTerapias = otrasTerapias;
	}

	public TipoPCI getTipoPCI() {
		return tipoPCI;
	}

	public void setTipoPCI(TipoPCI tipoPCI) {
		this.tipoPCI = tipoPCI;
	}
}