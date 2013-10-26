Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: 'CATEG',
	appFolder: 'category',
	controllers: [
		'CategoryController'
	],
	launch: function() {
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'categorylist'
			}]
		})
	}
})