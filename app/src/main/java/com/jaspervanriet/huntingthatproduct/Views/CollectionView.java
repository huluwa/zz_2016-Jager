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

package com.jaspervanriet.huntingthatproduct.Views;

import android.content.Context;

import com.jaspervanriet.huntingthatproduct.Views.Adapters.CollectionListAdapter;

public interface CollectionView {

	void initializeRecyclerView ();

	void setAdapterForRecyclerView (CollectionListAdapter adapter);

	void setToolbarTitle (String title);

	void showRefreshIndicator ();

	void hideRefreshIndicator ();

	void hideActivityTransition ();

	Context getContext ();

	CollectionListAdapter.OnCollectionClickListener getCollectionClickListener ();
}
