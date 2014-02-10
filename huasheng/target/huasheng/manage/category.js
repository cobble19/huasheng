Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: "HS",
	appFolder: "huasheng",
	
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