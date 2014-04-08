Ext.define('HS.view.role.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.roleedit',
	
	title: '角色',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'roleId',
						fieldLabel: '角色唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'roleName',
						fieldLabel: '角色名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, {
						xtype: 'privilegecheckboxgroup'
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