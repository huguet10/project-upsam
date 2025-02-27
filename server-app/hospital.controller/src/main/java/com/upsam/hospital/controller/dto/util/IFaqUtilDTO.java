package com.upsam.hospital.controller.dto.util;

import com.upsam.hospital.controller.dto.FaqDTO;
import com.upsam.hospital.controller.exception.TransferObjectException;
import com.upsam.hospital.model.beans.Faq;

// TODO: Auto-generated Javadoc
/**
 * The Class IFaqUtilDTO.
 */
public interface IFaqUtilDTO {

	/**
	 * To rest.
	 * 
	 * @param faq
	 *            the faq
	 * @return the faq dto
	 * @throws TransferObjectException
	 *             the transfer object exception
	 */
	FaqDTO toRest(Faq faq) throws TransferObjectException;

}
