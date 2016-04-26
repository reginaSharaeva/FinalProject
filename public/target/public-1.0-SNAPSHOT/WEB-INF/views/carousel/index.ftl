<#--<!DOCTYPE html>-->
<#--<html >-->
  <#---->
<#--<head>-->
    <#---->
<#--<meta charset="UTF-8">-->
    <#---->
<#--<title>Responsive Infinite Carousel</title>-->
    <#---->
<#--<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, minimum-scale=1, user-scalable=no" />-->

<#--<script type="text/javascript" src="//use.typekit.net/kei2cfp.js"></script>-->

<#--<script type="text/javascript">try{Typekit.load();}catch(e){}</script>-->
    <#---->
    <#---->
    
        
<style>
      /* NOTE: The styles were added inline because Prefixfree needs access to your styles and they must be inlined if they are on local disk! */
      
* {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

body, html {
  font-family: "europa-1","europa-2", sans-serif;
}

.wrapper {
  max-width: 940px;
  width: 100%;
  position: relative;
  overflow: hidden;
  margin: 0 auto;
}

/**
 * Use this wrapper only for demo purposes
 * So you can show the items outside the wrapper
 */
.wrapper--demo {
  overflow: hidden;
}
.wrapper--demo:after, .wrapper--demo:before {
  content: "";
  position: absolute;
  width: 800px;
  height: 100%;
  top: 0;
  left: 100%;
  background: rgba(255, 255, 255, 0.8);
  z-index: 2;
}
.wrapper--demo:before {
  left: -800px;
}

.carousel {
  width: 100%;
  position: relative;
}
.carousel .carousel__content {
  width: auto;
  position: relative;
  overflow: hidden;
  -webkit-backface-visibility: hidden;
  -webkit-transition: translate3d(0, 0, 0);
}
.carousel .carousel__content .item {
  display: block;
  float: left;
  width: 100%;
  position: relative;
}
.carousel .carousel__content .item .title {
  position: absolute;
  top: 50%;
  left: 0;
  margin: -33px 0 0 0;
  padding: 0;
  font-size: 3rem;
  width: 100%;
  text-align: center;
  letter-spacing: .3rem;
  color: #FFF;
}
.carousel .carousel__content .item .title--sub {
  margin-top: 20px;
  font-size: 1.2em;
  opacity: .5;
}
.carousel .carousel__content .item img {
  width: 100%;
  max-width: 100%;
  display: block;
}
.carousel .carousel__nav {
  position: absolute;
  width: 100%;
  top: 50%;
  margin-top: -17px;
  left: 0;
  z-index: 1;
}
.carousel .carousel__nav .nav {
  position: absolute;
  top: 0;
  color: #000;
  background: #FFF;
  padding: 8px 12px;
  font-weight: bold;
  text-decoration: none;
  font-size: .8rem;
  transition: padding .25s ease;
}
.carousel .carousel__nav .nav:hover {
  padding: 8px 20px;
}
.carousel .carousel__nav .nav--left {
  border-radius: 0px 3px 3px 0px;
}
.carousel .carousel__nav .nav--right {
  right: 0;
  border-radius: 3px 0px 0px 3px;
}

    </style>

    <#---->
        <#--<script src="/resources/js/prefixfree.min.js"></script>-->

    <#---->
  <#--</head>-->

  <#--<body>-->

    <div class="wrapper wrapper--demo">
	<div class="carousel">
		<div class="carousel__content">
			<div class="item">
               <img src="/resources/images/magazin-igrushek1.jpg" class="img-carousel-main" alt="">
            </div>

            <div class="item">
              <img src="/resources/images/magazin-igrushek2.jpg" class="img-carousel-main" alt="">
            </div>
            <div class="item">
                <img src="/resources/images/mir.jpg" class="img-carousel-main" alt="">
            </div>

            <div class="item">
                <img src="/resources/images/mir-igrushek.png" class="img-carousel-main" alt="">
            </div>
        </div>
    
    <div class="carousel__nav">
      <a href="#" class="nav nav--left"><img src="/resources/images/strelka1.png" style="height: 10px; width: 10px"></a>
      <a href="#" class="nav nav--right"><img src="/resources/images/strelka.png" style="height: 10px; width: 10px"></a>
    </div>
    
	</div>
</div>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
    <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery.transit/0.9.9/jquery.transit.min.js'></script>
    <script src="/resources/js/index.js"></script>
  <#--</body>-->
<#--</html>-->
