Ext.define('HS.controller.ContentController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox', 'HS.view.topic.Edit', 'HS.view.topic.List'],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	
	init: function() {
	}
})