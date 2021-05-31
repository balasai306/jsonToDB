<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <link rel="stylesheet" href="animations.css"> 
</head>

<body>
    <a href="display.html">click to store data</a>
       <a href="display.html">fetch data</a>
    <br><br>
    <button id="anim-1" class="Animation" name="Anim-1" onclick="anim1()">Anim-1</button>
    <br><br>
    <div id="target">
        

    </div>
    <br><br>
    <button id="anim-2" class="Animation" name="Anim-2">Anim-2</button>
    <br><br>
    <button id="anim-3" class="Animation" name="Anim-3">Anim-3</button>
    <br><br>
<script>
    function anim1(){
       var animation= document.getElementById("target")
       animation.className="animate";


    }
</script>
<!-- 
  <script>
    /* <![CDATA[ */

    function DoAnimation() {
      var targetElement = document.getElementById("target");
      targetElement.className = "animate";
    }
    /* ]]> */
  </script>
</head>
<body>
  <h1>CSS Animations</h1>
  <div id="target">Super div</div>
  <button onclick="DoAnimation();">Go</button>
</body>
</html> -->

</body>

</html>