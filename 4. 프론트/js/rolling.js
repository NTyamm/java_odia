function rollingToTop(parentSlector,childSelector,moveTime,animationTime){
  var heigth = $(parentSlector).height();
  return setInterval(function(){   
  if(!$(prerntSelector+'>'+childSelector).first().is(':animated')){
  $(prerntSelector+'>'+childSelector).first()
  .animate({marginTop:-height},animationTime,function(){
   $(this).removeAttr('style').detach().appendTo(prerntSelector);
  });
}
},moveTime);;
}

function rollingToLeft(ancestor,parentSelctor,childSelector,moveTime,animationTime){
  return setInterval(function(){
    if(!$(ancestor + " "+ childSelector).first().is(':animated')){
      var width = $(ancestor + " "+ childSelector).width();
      $(ancestor + " "+ childSelector).first().animate({marginLeft: -width},animationTime,function(){
        $(this).removeAttr('style').detach().appendTo(prerntSelector);
      });
    }
  },moveTime)
}