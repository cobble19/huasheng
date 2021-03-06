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
						name: 'name',
						fieldLabel: '名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					},  
					{
						xtype: 'textfield',
						name: 'url',
						fieldLabel: '视频url',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'orderNum',
						fieldLabel: '视频排序',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'title',
						fieldLabel: '标题'
					}, 
					{
						xtype: 'textfield',
						name: 'text',
						fieldLabel: '显示内容'
					}, 
					{
						xtype: 'textfield',
						name: 'target',
						fieldLabel: '打开方式'
					},
					{
						xtype: 'itemcombobox',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					},
					{
						xtype: 'videosrccombobox',
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