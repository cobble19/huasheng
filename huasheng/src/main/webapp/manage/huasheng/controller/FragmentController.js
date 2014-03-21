Ext.define('HS.controller.FragmentController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['FragmentStore'],
	models: ['FragmentModel'],
	views: ['fragment.List'],
	refs: [{
		ref: 'fragmentList',
		selector: 'viewport fragmentlist'
	}],
	init: function() {
		this.control({
			'viewport fragmentlist button[action=search]': {
				click: this.searchFragment
			}
		});
	},
	searchFragment: function(button) {
		var urlEle = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.url]')[0];
		url = urlEle.getValue();
		var store = this.getFragmentStoreStore();
		store.load({
			params: {
	            'url': url
	        }
		});
		console.log('searchFragment...' + url);
	}
})