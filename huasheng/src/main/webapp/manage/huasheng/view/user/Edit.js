Ext.define('HS.view.user.Edit', {
	extend: 'Ext.window.Window',
	alias: 'widget.useredit',
	
	title: '用户',
	layout: 'fit',
	autoShow: true,
	initComponent: function() {
		this.items = [
			{
				xtype: 'form',
				items: [
					{
						xtype: 'textfield',
						name: 'userId',
						fieldLabel: '用户唯一标识'
					}, 
					{
						xtype: 'textfield',
						name: 'userName',
						fieldLabel: '用户名称',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'password',
						fieldLabel: '密码',
						allowBlank: false,
						blankText: '不能为空',
						allowOnlyWhitespace: false,
						msgTarget: 'under'
					}, 
					{
						xtype: 'textfield',
						name: 'enabled',
						fieldLabel: '有效'
					}, {
						xtype: 'rolecheckboxgroup'
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