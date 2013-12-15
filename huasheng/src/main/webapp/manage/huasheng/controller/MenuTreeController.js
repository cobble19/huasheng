Ext.define('HS.controller.MenuTreeController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['MenuTreeStore'],
	/*models: ['MenuTreeModel'],*/
	views: ['menuTree.List'],
	
	init: function() {
		this.control({
			'viewport menutreelist': {
				select: this.onSelect
			}
		});
	},
	onSelect: function(selModel, record, index, options) {
		if (record.get('leaf')) {
			console.log("selected: " + record.get('text'));
			Ext.getCmp('content-panel').layout.setActiveItem(record.getId() + '-list');
		}
	}
})