Ext.application({
	requires: [
		'Ext.container.Viewport'
	],
	name: "HS",
	appFolder: "huasheng",
	
	controllers: [
		'VideoSrcController'
	],
	launch: function() {
		console.log('videoSrc.js');
		Ext.create('Ext.container.Viewport', {
			layout: 'fit',
			items: [{
				xtype: 'videoSrclist'
			}]
		})
	}
})