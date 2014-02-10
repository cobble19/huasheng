Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: "HS",
	appFolder: "huasheng",
	
	controllers: [
		'ItemController'
	],
	launch: function() {
		console.log('item.js');
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'itemlist'
			}]
		})
	}
})