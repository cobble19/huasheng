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
	onLaunch: function(application) {
		this.fieldsEx.urlEle = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.url]')[0];
		this.fieldsEx.atagEle = Ext.ComponentQuery.query('panel textfield[name=fragmentDTOSearch.atag]')[0];
		this.fieldsEx.itemEle = Ext.ComponentQuery.query('panel textfield[name=itemDTO.itemId]')[0];
		this.fieldsEx.videoSrcEle = Ext.ComponentQuery.query('panel textfield[name=videoSrcDTO.videoSrcId]')[0];
	},
	fieldsEx: {
		urlEle: '',
		atagEle: '',
		itemEle: '',
		videoSrcEle: ''
	},
	checkSearch: function() {
		var ret = this.fieldsEx.urlEle.validate();
		var atagEle = this.fieldsEx.atagEle;
		ret = ret && atagEle.validate();

		var itemEle = this.fieldsEx.itemEle;
		itemEle.allowBlank = true;
		itemEle.clearInvalid();
		var videoSrcEle = this.fieldsEx.videoSrcEle;
		videoSrcEle.allowBlank = true;
		videoSrcEle.clearInvalid();
		return ret;
	},
	checkAdd: function() {
		var urlEle = this.fieldsEx.urlEle;
		var ret = urlEle.validate();
		var atagEle = this.fieldsEx.atagEle;
		ret = ret && atagEle.validate();
		var itemEle = this.fieldsEx.itemEle;
		itemEle.allowBlank = false;
		ret = ret && itemEle.validate();
		var videoSrcEle = this.fieldsEx.videoSrcEle;
		videoSrcEle.allowBlank = false;
		ret = ret && videoSrcEle.validate();
		return ret;
	},
	searchFragment: function(button) {
		if (!this.checkSearch()) {
			return;
		}
		var urlEle = this.fieldsEx.urlEle;
		url = urlEle.getValue();
		var atag = this.fieldsEx.atagEle.getValue();
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
		if (!this.checkAdd()) {
			return;
		}
		var urlEle = this.fieldsEx.urlEle;
		url = urlEle.getValue();
		var atag = this.fieldsEx.atagEle.getValue();
		var itemId = this.fieldsEx.itemEle.getValue();
		var videoSrcId = this.fieldsEx.videoSrcEle.getValue();
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