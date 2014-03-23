Ext.define('HS.view.topic.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.topicedit',
	
	title: '编辑主题',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'topicId',
						fieldLabel: '主题唯一标识'
					},
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '主题名称',
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
				text: '保存',
				action: 'save',
				id: 'btnSave'
			},
			{
				text: '添加',
				action: 'add',
				id: 'btnAdd'
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