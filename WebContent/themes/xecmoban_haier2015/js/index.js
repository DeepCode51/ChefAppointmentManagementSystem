var $ = function(id) {
	return "string" == typeof id ? document.getElementById(id) : id;
};
var Class = {
	create : function() {
		return function() {
			this.initialize.apply(this, arguments);
		}
	}
}
Object.extend = function(destination, source) {
	for ( var property in source) {
		destination[property] = source[property];
	}
	return destination;
}
var TransformView = Class.create();
TransformView.prototype = {
	// 容器对象,滑动对象,切换参数,切换数量
	initialize : function(container, slider, parameter, count, options) {
		if (parameter <= 0 || count <= 0)
			return;
		var oContainer = $(container), oSlider = $(slider), oThis = this;
		this.Index = 0;// 当前索引

		this._timer = null;// 定时器
		this._slider = oSlider;// 滑动对象
		this._parameter = parameter;// 切换参数
		this._count = count || 0;// 切换数量
		this._target = 0;// 目标参数

		this.SetOptions(options);

		this.Up = !!this.options.Up;
		this.Step = Math.abs(this.options.Step);
		this.Time = Math.abs(this.options.Time);
		this.Auto = !!this.options.Auto;
		this.Pause = Math.abs(this.options.Pause);
		this.onStart = this.options.onStart;
		this.onFinish = this.options.onFinish;

		oContainer.style.overflow = "hidden";
		oContainer.style.position = "relative";

		oSlider.style.position = "absolute";
		oSlider.style.top = oSlider.style.left = 0;
	},
	// 设置默认属性
	SetOptions : function(options) {
		this.options = {// 默认值
			Up : true,// 是否向上(否则向左)
			Step : 5,// 滑动变化率
			Time : 10,// 滑动延时
			Auto : true,// 是否自动转换
			Pause : 2000,// 停顿时间(Auto为true时有效)
			onStart : function() {
			},// 开始转换时执行
			onFinish : function() {
			}// 完成转换时执行
		};
		Object.extend(this.options, options || {});
	},
	// 开始切换设置
	Start : function() {
		if (this.Index < 0) {
			this.Index = this._count - 1;
		} else if (this.Index >= this._count) {
			this.Index = 0;
		}

		this._target = -1 * this._parameter * this.Index;
		this.onStart();
		this.Move();
	},
	// 移动
	Move : function() {
		clearTimeout(this._timer);
		var oThis = this, style = this.Up ? "top" : "left", iNow = parseInt(this._slider.style[style]) || 0, iStep = this
				.GetStep(this._target, iNow);

		if (iStep != 0) {
			this._slider.style[style] = (iNow + iStep) + "px";
			this._timer = setTimeout(function() {
				oThis.Move();
			}, this.Time);
		} else {
			this._slider.style[style] = this._target + "px";
			this.onFinish();
			if (this.Auto) {
				this._timer = setTimeout(function() {
					oThis.Index++;
					oThis.Start();
				}, this.Pause);
			}
		}
	},
	// 获取步长
	GetStep : function(iTarget, iNow) {
		var iStep = (iTarget - iNow) / this.Step;
		if (iStep == 0)
			return 0;
		if (Math.abs(iStep) < 1)
			return (iStep > 0 ? 1 : -1);
		return iStep;
	},
	// 停止
	Stop : function(iTarget, iNow) {
		clearTimeout(this._timer);
		this._slider.style[this.Up ? "top" : "left"] = this._target + "px";
	}
};
window.onload = function() {
	function Each(list, fun) {
		for (var i = 0, len = list.length; i < len; i++) {
			fun(list[i], i);
		}
	}
	;

	var objs = $("idNum").getElementsByTagName("li");

	var tv = new TransformView("idTransformView", "idSlider", 430, 4, {
		onStart : function() {
			Each(objs, function(o, i) {
				o.className = tv.Index == i ? "on" : "";
			})
		}// 按钮样式
	});

	tv.Start();

	Each(objs, function(o, i) {
		o.onmouseover = function() {
			o.className = "on";
			tv.Auto = false;
			tv.Index = i;
			tv.Start();
		}
		o.onmouseout = function() {
			o.className = "";
			tv.Auto = true;
			tv.Start();
		}
	})

	// //////////////////////test2

	var objs2 = $("idNum2").getElementsByTagName("li");

	var tv2 = new TransformView("idTransformView2", "idSlider2", 1200, 3, {
		onStart : function() {
			Each(objs2, function(o, i) {
				o.className = tv2.Index == i ? "on" : "";
			})
		},// 按钮样式
		Up : false
	});

	tv2.Start();

	Each(objs2, function(o, i) {
		o.onmouseover = function() {
			o.className = "on";
			tv2.Auto = false;
			tv2.Index = i;
			tv2.Start();
		}
		o.onmouseout = function() {
			o.className = "";
			tv2.Auto = true;
			tv2.Start();
		}
	})

	$("idStop").onclick = function() {
		tv2.Auto = false;
		tv2.Stop();
	}
	$("idStart").onclick = function() {
		tv2.Auto = true;
		tv2.Start();
	}
	$("idNext").onclick = function() {
		tv2.Index++;
		tv2.Start();
	}
	$("idPre").onclick = function() {
		tv2.Index--;
		tv2.Start();
	}
	$("idFast").onclick = function() {
		if (--tv2.Step <= 0) {
			tv2.Step = 1;
		}
	}
	$("idSlow").onclick = function() {
		if (++tv2.Step >= 10) {
			tv2.Step = 10;
		}
	}
	$("idReduce").onclick = function() {
		tv2.Pause -= 1000;
		if (tv2.Pause <= 0) {
			tv2.Pause = 0;
		}
	}
	$("idAdd").onclick = function() {
		tv2.Pause += 1000;
		if (tv2.Pause >= 5000) {
			tv2.Pause = 5000;
		}
	}

	$("idReset").onclick = function() {
		tv2.Step = Math.abs(tv2.options.Step);
		tv2.Time = Math.abs(tv2.options.Time);
		tv2.Auto = !!tv2.options.Auto;
		tv2.Pause = Math.abs(tv2.options.Pause);
	}

}