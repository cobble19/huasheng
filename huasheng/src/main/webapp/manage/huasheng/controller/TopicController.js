Ext.define('HS.controller.TopicController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['TopicStore'],
	models: ['TopicModel'],
	views: ['topic.List', 'topic.Edit'],
	init: function() {
		console.log("TopicController init...");
		this.control({
			'viewport > topiclist': {
				itemdblclick: this.editTopic
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport topiclist button[action=add]': {
				click: this.openDialog4Add
			},
			'topicedit button[action=add]': {
				click: this.addTopic
			},
			'viewport topiclist button[action=update]': {
				click: this.openDialog4Update
			},
			'topicedit button[action=save]': {
				click: this.updateTopic
			},
			'viewport topiclist button[action=delete]': {
				click: this.openDialog4Delete
			}
			/*'viewport > panel' : {
				render: this.onPanelRendered
			}*/
		});
	},
	openDialog4Add: function(button) {
		console.log('add dialog...');
		/*var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
		} else {
			Ext.MessageBox.alert('Info', records);
		}*/
		var view = Ext.widget('topicedit');
		var btns = Ext.query('a[id=btnSave]');
		Ext.Array.each(btns, function(btn) {
			Ext.get(btn).hide();
		})
		var inputTopicId = Ext.query('input[name=topicId]');
		Ext.get(inputTopicId).hide();
	},
	addTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var topicDTO = action.result.topicDTO;
				var index = 0;
				var records = Ext.getStore('TopicStore').insert(index, topicDTO);
				// change color
				var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red')
				//Ext.MessageBox.alert(action.response.statusText);
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
		
		
	},
	openDialog4Update: function(button) {
		console.log('update dialog...');
		var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
			return;
		} else {
			//Ext.MessageBox.alert('Info', records[0].data.name);
			var view = Ext.widget('topicedit');
			var btns = Ext.query('a[id=btnAdd]');
			Ext.Array.each(btns, function(btn) {
				Ext.get(btn).hide();
			})
			view.down('form').loadRecord(records[0]);
		}
	},
	updateTopic: function(button) {
		var win = button.up('window'),
			form = win.down('form'), 
			f = form.getForm();
		record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/topic!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				win.close();
				// change color
				var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
				Ext.get(tr).addCls('red')
				
				//Ext.getStore('TopicStore').sync();
				//Ext.MessageBox.alert(action.response.statusText);
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Delete: function(button) {
		console.log('delete dialog...');
		var grid = button.up('topiclist'),
			selModel = grid.getSelectionModel( ),
			records = selModel.getSelection();
		var deleteTopic = this.deleteTopic;
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Info', 'please select ONE row');
			return;
		} else {
			Ext.MessageBox.show({
				title: 'Confirm',
				icon: Ext.MessageBox.WARNING,
				msg: '确认删除数据？',
				buttons: Ext.Msg.OKCANCEL,
				/*multiline: true,*/
				fn : function(buttonId, text, opt) {
					if (buttonId == 'ok') {
						deleteTopic(records);
					}// end if
				}
			});
		}
		
	},
	deleteTopic: function(records) {
		var ids = [];
		Ext.Array.each(records, function(record) {
			ids.push(record.get('topicId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/topic!delete',
			method: 'POST',
			params: params,
			/*jsonData : params,*/
			success: function(response, options) {
				Ext.Array.each(records, function(record) {
					Ext.getStore('TopicStore').remove(record);
				}
				);
				/*Ext.getStore('TopicStore').sync();*/
				Ext.MessageBox.alert('Info', 'Deleted successfully!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('Alarm', 'Deleted fail!');
			}
		});
	},
	/*editTopic: function(grid, record) {
		console.log('Double clicked on ' + record.get('name'));
		var view = Ext.widget('topicedit');
		view.down('form').loadRecord(record);
	},*/
	/*updateTopic: function(button) {
		console.log('Clicked the save button.');
		var win = button.up('window'),
			form = win.down('form'),
			record = form.getRecord(),
			values = form.getValues();
		record.set(values);
		win.close();
		// synchronize the store
		this.getStore('TopicStore').sync();
	},*/
	onPanelRendered : function() {
		console.log('The panel was rendered.')
	}
});