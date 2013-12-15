Ext.define('VS.controller.VideoSrcController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['VideoSrcStore'],
	models: ['VideoSrcModel'],
	views: ['videoSrc.List','videoSrc.Edit'],
	init: function() {
		this.control({
			'viewport > videoSrclist button[action=add]': {
				click: this.openDialog4Add
			},
			'videoSrcedit button[action=add]': {
				click: this.addVideoSrc
			},
			'viewport > videoSrclist button[action=update]': {
				click: this.openDialog4Update
			},
			'videoSrcedit button[action=update]': {
				click: this.updateVideoSrc
			},
			'viewport > videoSrclist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('videoSrcedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=videoSrcId]');
		Ext.get(inputId).hide();
	},
	addVideoSrc: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/videoSrc!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var videoSrcDTO = action.result.videoSrcDTO;
				var encode = Ext.JSON.encode(videoSrcDTO);
				var decode = Ext.JSON.decode(encode);
				var record = Ext.create('VS.model.VideoSrcModel', {
					videoSrcId: videoSrcDTO.videoSrcId,
					name: videoSrcDTO.name
				});
				var index = 0;
				var records = Ext.getStore('VideoSrcStore').insert(index, record);
				// change color
				var tr = Ext.query('tr[data-recordindex=' + index + ']');
				Ext.get(tr).addCls('red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert(action.response.statusText);
			}
		});
	},
	openDialog4Update: function(button) {
		var grid = button.up('videoSrclist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('videoSrcedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateVideoSrc: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/videoSrc!update',
			method: 'POST',
			success: function(form, action) {
				record = form.getRecord();
				record.set(form.getValues());
				record.commit();
				// 1. set record, 2. close it.
				win.close();
				// change color
				var tr = Ext.query('tr[data-recordindex=' + record.index + ']');
				Ext.get(tr).addCls('red');
			},
			failure: function(form, action) {
				Ext.MessageBox.alert('Alarm', action.response.statusText);
			}
		})
	},
	openDialog4Delete: function(button) {
		var grid = button.up('videoSrclist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteVideoSrc = this.deleteVideoSrc;
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			Ext.MessageBox.show({
				title: 'Confirm',
				icon: Ext.MessageBox.WARNING,
				msg: '确认删除数据？',
				buttons: Ext.MessageBox.OKCANCEL,
				fn: function(buttonId, text, opt) {
					if ('ok' == buttonId) {
						deleteVideoSrc(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteVideoSrc: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('videoSrcId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/videoSrc!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('VideoSrcStore').remove(record);
				});
				Ext.MessageBox.alert('Info', 'Deleted successfully!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('Alarm', 'Deleted fail!');
			}
		});
	}
})