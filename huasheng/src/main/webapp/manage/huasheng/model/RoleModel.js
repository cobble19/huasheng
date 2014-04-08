Ext.define('HS.model.RoleModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'roleId', type: 'long', convert: null},
		{name: 'roleName', type: 'string'},
		{name: 'userEntities'}
	]
})