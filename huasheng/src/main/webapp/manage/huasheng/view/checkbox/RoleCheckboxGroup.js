Ext.define('HS.view.checkbox.RoleCheckboxGroup', {
	extend: 'Ext.form.CheckboxGroup',
	alias: 'widget.rolecheckboxgroup',
	fieldLabel: '权限',
	id: 'rolecheckboxgroup',
	name: 'rolecheckboxgroup',
	width: 300,
	/*height: 100,*/
	columns: 2,
	items: [
	],
	listeners: {
		beforerender: function(cmp, eOpts) {
			//console.log('cmp:' + cmp);
			Ext.getStore('RoleStore').load({
			    scope: this,
			    params: {
			    	limit: 1000
			    },
			    callback: function(records, operation, success) {
			    	Ext.each(records, function(record) {
			    		var checked = false;
			    		var form = cmp.up('form'),
						//f = form.getForm(),
						userRecord = form.getRecord();
			    		if (!!userRecord) {
				    		userId = userRecord.data.userId;
				    		console.log('userId:' + userId);
				    		if (record.data.userEntities != null) {
				    			Ext.each(record.data.userEntities, function(userEntity) {
				    				if (userId == userEntity.userId) {
				    					checked = true;
				    				}
				    			});
				    		}
			    		}
			    		cmp.add({
			    			boxLabel: record.data.roleName,
			    			name: 'roleIds',
			    			value: record.data.roleId,
			    			inputValue: record.data.roleId,
			    			checked: checked
			    		});
			    	});
			    }
			});
		}
	}
})