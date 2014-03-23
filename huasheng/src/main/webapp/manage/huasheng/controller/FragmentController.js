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
			},
			'viewport fragmentlist button[action=add]': {
				click: this.addFragment
			}
		});
	},
	searchFragment: function(button) {
		var urlEle = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.url]')[0];
		url = urlEle.getValue();
		var atag = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.atag]')[0].getValue();
		var store = this.getFragmentStoreStore();
		store.load({
			params: {
	            'fragmentDTOSearch.url': url,
	            'fragmentDTOSearch.atag': atag
	        }
		});
		console.log('searchFragment...' + url);
	},
	addFragment: function(button) {
		var urlEle = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.url]')[0];
		url = urlEle.getValue();
		var atag = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.atag]')[0].getValue();
		var itemId = Ext.ComponentQuery.query('panel textfield[name=itemDTO.itemId]')[0].getValue();
		var videoSrcId = Ext.ComponentQuery.query('panel textfield[name=videoSrcDTO.videoSrcId]')[0].getValue();
		Ext.Ajax.request({
		    url: Ext.get('contextPath').dom.value + '/json/handleUrl!add',
		    params: {
	            'fragmentDTOSearch.url': url,
	            'fragmentDTOSearch.atag': atag,
	            'itemDTO.itemId': itemId,
	            'videoSrcDTO.videoSrcId': videoSrcId
	        },
		    success: function(response, opts) {
		    	console.log('success with status code ' + response.status);
		    },
		    failure: function(response, opts) {
		        console.log('server-side failure with status code ' + response.status);
		    }
		});
		console.log('addFragment...' + url);
	}
})