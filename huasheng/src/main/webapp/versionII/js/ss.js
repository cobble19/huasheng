(function(){
  var o = document.getElementById("hutia");
  var s = o.innerHTML;
  var p = document.createElement("span");
  var n = document.createElement("a");
  p.innerHTML = s.length > 250 ? s.substring(0,250)+"..." : s.substring(0,250);
  n.innerHTML = s.length > 250 ? "展开" : "";
  n.href = "###";
  n.onclick = function(){
    if (n.innerHTML == "展开"){
      n.innerHTML = "收起";
      p.innerHTML = s;
    }else{
      n.innerHTML = "展开";
      p.innerHTML = s.substring(0,250)+"...";
    }
  }
  o.innerHTML = "";
  o.appendChild(p);
  o.appendChild(n);
})();