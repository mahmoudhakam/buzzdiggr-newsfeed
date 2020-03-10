package com.buzzdiggr.web.rest.errors.custom;

import lombok.Getter;
import lombok.Setter;

/**
 * @author MahmoudHakam
 * This class indicate a no result found query will move control to spring boot advice controller. To unify exception handling mechanism for the whole
 * app
 */
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException
{
	private String errorNumber = BuzzdiggrMessages.RESOURCE_NOT_FOUND.getErrorNumber();
	private String errorMessage = BuzzdiggrMessages.RESOURCE_NOT_FOUND.getErrorMessage();

}
