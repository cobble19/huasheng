Ext.define('HS.controller.MenuTreeController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['MenuTreeStore'],
	/*models: ['MenuTreeModel'],*/
	views: ['menuTree.List'],
	
	init: function() {
		this.control({
			'viewport menutreelist': {
				select: this.onSelect,
				afterrender: this.onAfterrender
			}
		});
	},
	onSelect: function(selModel, record, index, options) {
		console.log("selected: " + record.getId() + " " + record.get('text') + ", index=" + index);
		if (record.get('leaf')) {
			Ext.getCmp('content-panel').layout.setActiveItem(record.getId() + '-list');
			Ext.getCmp('content-panel').layout.getActiveItem().getStore().load();
		}
	},
	onAfterrender: function(tree, options) {
		console.log('tree after render');
		tree.getSelectionModel().select(1);
	}
})