Ext.define('HS.view.user.EditPwd', {
	extend: 'Ext.window.Window',
	alias: 'widget.usereditpwd',
	
	title: '用户修改密码',
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
						fieldLabel: '用户唯一标识',
						readOnly: true
					}, 
					{
						xtype: 'textfield',
						name: 'userName',
						fieldLabel: '用户名称',
						readOnly: true
					}, 
					{
						xtype: 'textfield',
						name: 'password',
						fieldLabel: '密码',
						inputType: 'password',
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
			text: '修改',
			action: 'changePwd',
			id: 'btnChangePwd'
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