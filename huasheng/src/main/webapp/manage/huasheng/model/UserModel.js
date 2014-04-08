Ext.define('HS.model.UserModel', {
	extend: 'Ext.data.Model',
	fields: [
		{name: 'userId', type: 'long', convert: null},
		{name: 'userName', type: 'string'},
		{name: 'password', type: 'string'},
		{name: 'enabled', 
			type: 'boolean', 
			defaultValue: true, 
			convert: function(value, record) {
				return value;
			}
		}
	]
})