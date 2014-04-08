Ext.define('HS.model.PrivilegeModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'privilegeId', type: 'long', convert: null},
		{name: 'name', type: 'string'},
		{name: 'resource', type: 'string'},
		{name: 'roleEntities'}
	]
})