Ext.define('HS.view.privilege.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.privilegeedit',
	
	title: '权限',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'privilegeId',
						fieldLabel: '权限唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'name',
						fieldLabel: '权限名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'resource',
						fieldLabel: '权限URL',
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