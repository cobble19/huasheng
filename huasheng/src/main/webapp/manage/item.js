Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: 'ITEM',
	appFolder: 'item',
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