Ext.define('HS.view.videoSrc.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.videosrcedit',
	
	title: '视频源编辑',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'videoSrcId',
						fieldLabel: '视频源唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '视频源名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
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