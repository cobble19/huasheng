Ext.define('HS.view.video.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.videoedit',
	
	title: '视频编辑',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'videoId',
						fieldLabel: '视频唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'url',
						fieldLabel: '视频url'
					}, 
					{
						xtype: 'textfield',
						name: 'orderNum',
						fieldLabel: '视频排序'
					}/*, 
					{
						xtype: 'textfield',
						name: 'itemDTO.itemId',
						fieldLabel: 'Item Id'
					}, 
					{
						xtype: 'textfield',
						name: 'videoSrcDTO.videoSrcId',
						fieldLabel: 'VideoSrc Id'
					}*/,
					{
						xtype: 'itemcombobox'
					},
					{
						xtype: 'videosrccombobox'
					}
				]
			}
		];
		this.buttons = [
		{
			text: '添加',
			action: 'add',
			id: 'btnAdd'
		},
		{
			text: '修改',
			action: 'update',
			id: 'btnUpdate'
		}, 
		{
			text: '取消',
			scope: this,
			handler: this.close
		}
		];
		this.callParent(arguments);
	}
})