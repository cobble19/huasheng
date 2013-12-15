Ext.application({
	requires: ['Ext.container.Viewport'],
	name: "HS",
	appFolder: "huasheng",
	
	controllers: [
		'MenuTreeController',
		/*'ContentController',*/
		'TopicController',
		'CategoryController',
		'ItemController',
		'VideoSrcController',
		'VideoController'
	],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	views: ['content.Panel'],
	launch: function() {
		Ext.create('Ext.container.Viewport', {
			layout: "border",
			title: 'manage platform view',
			items: [
				{
					xtype: 'component',
					region: 'north',
					id: 'header',
					height: 40,
					html: '<h4>Manage Platform</h4>'
				}, {
					xtype: 'menutreelist',
					region: 'west',
					width: 150
				}, {
					xtype: 'contentpanel',
					region: 'center'
				}, {
					xtype: 'component',
					region: 'east',
					html: 'east'
				}, {
					xtype: 'component',
					region: 'south',
					html: 'south'
				}
			]
		});
	}
	
})