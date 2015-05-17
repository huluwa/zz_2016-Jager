/*
 * Copyright (C) 2015 Jasper van Riet
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.jaspervanriet.huntingthatproduct.Data.Http;

import com.google.gson.Gson;
import com.jaspervanriet.huntingthatproduct.Entities.AccessToken;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

public class ServiceGenerator {

	private ServiceGenerator () {
	}

	public static <S> S createService (Class<S> serviceClass, String baseUrl) {
		RestAdapter restAdapter = new RestAdapter.Builder ()
				.setEndpoint (baseUrl)
				.build ();

		return restAdapter.create (serviceClass);
	}

	public static <S> S createService (Class<S> serviceClass,
	                                   String baseUrl,
	                                   final AccessToken accessToken) {
		RestAdapter restAdapter = new RestAdapter.Builder ()
				.setEndpoint (baseUrl)
				.setRequestInterceptor (requestFacade -> {
					requestFacade.addHeader ("Accept", "application/json");
					requestFacade.addHeader ("Authorization",
							"Bearer " + accessToken.getAccessToken ());
				})
				.build ();
		return restAdapter.create (serviceClass);
	}

	public static <S> S createService (Class<S> serviceClass,
	                                   String baseUrl,
	                                   final AccessToken accessToken,
	                                   Gson gson) {
		RestAdapter restAdapter = new RestAdapter.Builder ()
				.setEndpoint (baseUrl)
				.setConverter (new GsonConverter (gson))
				.setRequestInterceptor (requestFacade -> {
					requestFacade.addHeader ("Accept", "application/json");
					requestFacade.addHeader ("Authorization",
							"Bearer " + accessToken.getAccessToken ());
				})
				.build ();
		return restAdapter.create (serviceClass);
	}

}