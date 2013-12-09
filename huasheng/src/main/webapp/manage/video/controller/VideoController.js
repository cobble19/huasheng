Ext.define('VIDEO.controller.VideoController', {
	extend: 'Ext.app.Controller',
	requires: ['Ext.window.MessageBox'],
	stores: ['VideoStore'],
	models: ['VideoModel'],
	views: ['video.List','video.Edit'],
	init: function() {
		this.control({
			'viewport > videolist button[action=add]': {
				click: this.openDialog4Add
			},
			'videoedit button[action=add]': {
				click: this.addVideo
			},
			'viewport > videolist button[action=update]': {
				click: this.openDialog4Update
			},
			'videoedit button[action=update]': {
				click: this.updateVideo
			},
			'viewport > videolist button[action=delete]': {
				click: this.openDialog4Delete
			}
		});
	},
	openDialog4Add: function(button) {
		console.log('open dialog for add');
		var view = Ext.widget('videoedit');
		// hide update button
		var btns = Ext.query('a[id=btnUpdate]');
		Ext.each(btns, function(btn) {
			Ext.get(btn).hide();
		});
		// hide id input
		var inputId = Ext.query('input[name=videoId]');
		Ext.get(inputId).hide();
	},
	addVideo: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/video!add',
			method: 'POST',
			success: function(form, action) {
				win.close();
				var videoDTO = action.result.videoDTO;
				var encode = Ext.JSON.encode(videoDTO);
				var decode = Ext.JSON.decode(encode);
				var record = Ext.create('VIDEO.model.VideoModel', {
					videoId: videoDTO.videoId,
					url: videoDTO.url,
					orderNum: videoDTO.orderNum,
					"itemDTO.itemId": videoDTO.itemDTO.itemId,
					"videoSrcDTO.videoSrcId": videoDTO.videoSrcDTO.videoSrcId
				});
				var index = 0;
				var records = Ext.getStore('VideoStore').insert(index, record);
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
		var grid = button.up('videolist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		if (records == null || records.length == 0) {
			Ext.MessageBox.alert('Alarm', 'Please select ONE row!');
			return;
		} else {
			// display edit window
			var view = Ext.widget('videoedit');
			// hide add button
			var btns = Ext.query('a[id=btnAdd]');
			Ext.each(btns, function(btn){
				Ext.get(btn).hide();
			});
			// load rowdata that will be updated 
			view.down('form').loadRecord(records[0]);
		}
	},
	updateVideo: function(button) {
		var win = button.up('window'),
			form = win.down('form'),
			f = form.getForm(),
			record = form.getRecord();
		f.doAction('submit', {
			url: Ext.get('contextPath').dom.value + '/json/video!update',
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
		var grid = button.up('videolist'),
			selModel = grid.getSelectionModel(),
			records = selModel.getSelection();
		var deleteVideo = this.deleteVideo;
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
						deleteVideo(records);
						return;
					} else {
						return;
					}
				}
			});
		}
	},
	deleteVideo: function(records) {
		var ids = [];
		Ext.each(records, function(record) {
			ids.push(record.get('videoId'));
		});
		params = {
			'ids': ids.join(',')
		};
		Ext.Ajax.request({
			url: Ext.get('contextPath').dom.value + '/json/video!delete',
			method: 'POST',
			params: params,
			success: function(response, options) {
				Ext.Array.each(records, function(record){
					Ext.getStore('VideoStore').remove(record);
				});
				Ext.MessageBox.alert('Info', 'Deleted successfully!');
			},
			failure: function(response, options) {
				Ext.MessageBox.alert('Alarm', 'Deleted fail!');
			}
		});
	}
})