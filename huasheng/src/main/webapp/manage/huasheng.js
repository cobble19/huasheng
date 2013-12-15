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
					margins: '0 0 0 2',
					width: 150
				}, {
					xtype: 'contentpanel',
					margins: '0 2 0 2',
					region: 'center'
				}, {
					xtype: 'component',
					region: 'east',
					html: ''
				}, {
					xtype: 'component',
					region: 'south',
					margins: '5',
					html: 'copyright &copy; Email: publiclzhc@sina.com'
				}
			]
		});
	}
	
})