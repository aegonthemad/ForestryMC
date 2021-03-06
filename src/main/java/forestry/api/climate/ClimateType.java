/*******************************************************************************
 * Copyright 2011-2014 SirSengir
 *
 * This work (the API) is licensed under the "MIT" License, see LICENSE.txt for details.
 ******************************************************************************/
package forestry.api.climate;

import java.util.Locale;

/**
 * This enum contains the two climate types that forestry uses.
 */
public enum ClimateType {
	TEMPERATURE, HUMIDITY;

	public String getName() {
		return name().toLowerCase(Locale.ENGLISH);
	}

}
