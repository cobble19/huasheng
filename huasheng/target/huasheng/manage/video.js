Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: "HS",
	appFolder: "huasheng",
	
	controllers: [
		'VideoController'
	],
	launch: function() {
		console.log('video.js');
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'videolist'
			}]
		})
	}
})