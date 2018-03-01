package com.fluxextreme.moneyflux.dataservice.services;

import com.fluxextreme.moneyflux.dataservice.objects.FEResponseBean;

public interface UserSettingsService {

	FEResponseBean getUserDetailsById(Long userId);
}
