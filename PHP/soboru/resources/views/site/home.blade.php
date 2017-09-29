@extends('layouts.site.master')

@section('content')
    <main class="main" role="main">
        <div class="intro">
            <figure class="bg"><img src="images/intro.jpg" alt="" /></figure>

            <div class="wrap clearfix">
                <div class="row">
                    <article class="three-fourth text">
                        <h1>Welcome to SocialChef!</h1>
                        <p>SocialChef is the ultimate <strong>cooking social community</strong>, where recipes come to life. Wanna know what you will gain by joining us? Lorem ipsum dolor sit amet, this is some teaser text.</p>
                        <p>You will win awesome prizes, make new friends and share delicious recipes. </p>
                        <a href="register.html" class="button white more medium">Join our community <i class="fa fa-chevron-right"></i></a>
                        <p>Already a member? Click <a href="login.html">here</a> to login.</p>
                    </article>
                    
                    <div class="one-fourth">
                        <div class="widget container">
                            <div class="textwrap">
                                <h3>Search for recipes</h3>
                                <p>All you need to do is enter an igredient, a dish or a keyword. </p>
                                <p>You can also select a specific category from the dropdown.</p>
                                <p>There’s sure to be something tempting for you to try.</p> 
                                <p>Enjoy!</p>
                            </div>
                            <form action="find_recipe.html">
                                <div class="f-row">
                                    <input type="text" placeholder="Enter your search term" />
                                </div>
                                <div class="f-row">
                                    <select>
                                        <option>or select a category</option>
                                        <option>Apetizers</option>
                                        <option>Cocktails</option>
                                        <option>Deserts</option>
                                        <option>Main courses</option>
                                        <option>Snacks</option>
                                        <option>Soups</option>
                                    </select>
                                </div>
                                <div class="f-row bwrap">
                                    <input type="submit" value="Start cooking!" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <div class="wrap clearfix">
            <div class="row">
                <section class="content full-width">
                    <div class="icons dynamic-numbers">
                        <header class="s-title">
                            <h2 class="ribbon large">SocialChef in numbers</h2>
                        </header>
                        
                        <div class="row">
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_chef-hat"></i>
                                    <span class="title dynamic-number" data-dnumber="1730">0</span>
                                    <span class="subtitle">members</span>
                                </div>
                            </div>
                            
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_pan"></i>
                                    <span class="title dynamic-number" data-dnumber="1250">0</span>
                                    <span class="subtitle">recipes</span>
                                </div>
                            </div>
                            
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_image"></i>
                                    <span class="title dynamic-number" data-dnumber="5300">0</span>
                                    <span class="subtitle">photos</span>
                                </div>
                            </div>
                            
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_pencil"></i>
                                    <span class="title dynamic-number" data-dnumber="2300">0</span>
                                    <span class="subtitle">forum posts</span>
                                </div>
                            </div>
                            
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_chat-bubbles"></i>
                                    <span class="title dynamic-number" data-dnumber="7400">0</span>
                                    <span class="subtitle">comments</span>
                                </div>
                            </div>
                            
                            <div class="one-sixth">
                                <div class="container">
                                    <i class="icon icon-themeenergy_stars"></i>
                                    <span class="title dynamic-number" data-dnumber="1700">0</span>
                                    <span class="subtitle">articles</span>
                                </div>
                            </div>
                        
                            <div class="cta">
                                <a href="login.html" class="button big">Join us!</a>
                            </div>
                        </div>
                    </div>
                </section>
            
                <section class="content three-fourth">
                    <div class="cwrap">
                        <div class="entries row">
                            <div class="featured two-third">
                                <header class="s-title">
                                    <h2 class="ribbon">Recipe of the Day</h2>
                                </header>
                                <article class="entry">
                                    <figure>
                                        <img src="images/img2.jpg" alt="" />
                                        <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                    </figure>
                                    <div class="container">
                                        <h2><a href="recipe.html">Honey Cake</a></h2>
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. </p>
                                        <div class="actions">
                                            <div>
                                                <a href="#" class="button">See the full recipe</a>
                                                <div class="more"><a href="recipes2.html">See past recipes of the day</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                            </div>
                            
                            <div class="featured one-third">
                                <header class="s-title">
                                    <h2 class="ribbon star">Featured member</h2>
                                </header>
                                <article class="entry">
                                    <figure>
                                        <img src="images/avatar1.jpg" alt="" />
                                        <figcaption><a href="my_profile.html"><i class="icon icon-themeenergy_eye2"></i> <span>View member</span></a></figcaption>
                                    </figure>
                                    <div class="container">
                                        <h2><a href="my_profile.html">Kimberly C.</a></h2>
                                        <blockquote><i class="fa fa-quote-left"></i>Traditional dishes and fine bakery products accompanied by beautiful photographs to bend around and attract the tryout! Lorem ipsum dolor sit amet, consectetuer adipiscing elit.</blockquote>
                                        <div class="actions">
                                            <div>
                                                <a href="#" class="button">Check out her recipes</a>
                                                <div class="more"><a href="#">See past featured members</a></div>
                                            </div>
                                        </div>
                                    </div>
                                </article>
                            </div>
                        </div>
                    </div>
                
                    <div class="cwrap">
                        <header class="s-title">
                            <h2 class="ribbon bright">Latest recipes</h2>
                        </header>
                        
                        <div class="entries row">
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img6.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Thai fried rice with fruit and vegetables</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-medium"></i><a href="#">medium</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img5.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Spicy Morroccan prawns with cherry tomatoes</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img8.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Super easy blueberry cheesecake</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-easy"></i><a href="#">easy</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img7.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Refreshing banana split with a twist for adults</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img3.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Sushi mania: this is the best sushi you have ever tasted</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-easy"></i><a href="#">easy</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img4.jpg" alt="" />
                                    <figcaption><a href="recipe.html"><i class="icon icon-themeenergy_eye2"></i> <span>View recipe</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="recipe.html">Princess puffs - an old classic at its best</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="difficulty"><i class="ico i-hard"></i><a href="#">hard</a></div>
                                            <div class="likes"><i class="fa fa-heart"></i><a href="#">10</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="recipe.html#comments">27</a></div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="quicklinks">
                                <a href="#" class="button">More recipes</a>
                                <a href="javascript:void(0)" class="button scroll-to-top">Back to top</a>
                            </div>
                        </div>
                    </div>
                
                    <div class="cwrap">
                        <header class="s-title">
                            <h2 class="ribbon bright">Latest articles</h2>
                        </header>
                        <div class="entries row">
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img12.jpg" alt="" />
                                    <figcaption><a href="blog_single.html"><i class="icon icon-themeenergy_eye2"></i> <span>View post</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="blog_single.html">Barbeque party</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="date"><i class="fa fa-calendar"></i><a href="#">22 Dec 2014</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="blog_single.html#comments">27</a></div>
                                        </div>
                                    </div>
                                    <div class="excerpt">
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img11.jpg" alt="" />
                                    <figcaption><a href="blog_single.html"><i class="icon icon-themeenergy_eye2"></i> <span>View post</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="blog_single.html">How to make sushi</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="date"><i class="fa fa-calendar"></i><a href="#">22 Dec 2014</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="blog_single.html#comments">27</a></div>
                                        </div>
                                    </div>
                                    <div class="excerpt">
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="entry one-third">
                                <figure>
                                    <img src="images/img10.jpg" alt="" />
                                    <figcaption><a href="blog_single.html"><i class="icon icon-themeenergy_eye2"></i> <span>View post</span></a></figcaption>
                                </figure>
                                <div class="container">
                                    <h2><a href="blog_single.html">Make your own bread</a></h2> 
                                    <div class="actions">
                                        <div>
                                            <div class="date"><i class="fa fa-calendar"></i><a href="#">22 Dec 2014</a></div>
                                            <div class="comments"><i class="fa fa-comment"></i><a href="blog_single.html#comments">27</a></div>
                                        </div>
                                    </div>
                                    <div class="excerpt">
                                        <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod. Lorem ipsum dolor sit amet . . . </p>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="quicklinks">
                                <a href="#" class="button">More posts</a>
                                <a href="javascript:void(0)" class="button scroll-to-top">Back to top</a>
                            </div>
                        </div>
                    </div>
                </section>
        
            
                <aside class="sidebar one-fourth">
                    <div class="widget">
                        <h3>Recipe Categories</h3>
                        <ul class="boxed">
                            <li class="light"><a href="recipes.html" title="Appetizers"><i class="icon icon-themeenergy_pasta"></i> <span>Apetizers</span></a></li>
                            <li class="medium"><a href="recipes.html" title="Cocktails"><i class="icon icon-themeenergy_margarita2"></i> <span>Cocktails</span></a></li>
                            <li class="dark"><a href="recipes.html" title="Deserts"><i class="icon icon-themeenergy_cupcake"></i> <span>Deserts</span></a></li>
                            
                            <li class="medium"><a href="recipes.html" title="Cocktails"><i class="icon icon-themeenergy_eggs"></i> <span>Eggs</span></a></li>
                            <li class="dark"><a href="recipes.html" title="Equipment"><i class="icon icon-themeenergy_blender"></i> <span>Equipment</span></a></li>
                            <li class="light"><a href="recipes.html" title="Events"><i class="icon icon-themeenergy_turkey"></i> <span>Events</span></a></li>
                        
                            <li class="dark"><a href="recipes.html" title="Fish"><i class="icon icon-themeenergy_fish2"></i> <span>Fish</span></a></li>
                            <li class="light"><a href="recipes.html" title="Ftness"><i class="icon icon-themeenergy_biceps"></i> <span>Fitness</span></a></li>
                            <li class="medium"><a href="recipes.html" title="Healthy"><i class="icon icon-themeenergy_apple2"></i> <span>Healthy</span></a></li>
                            
                            <li class="light"><a href="recipes.html" title="Asian"><i class="icon icon-themeenergy_sushi"></i> <span>Asian</span></a></li>
                            <li class="medium"><a href="recipes.html" title="Mexican"><i class="icon icon-themeenergy_peper"></i> <span>Mexican</span></a></li>
                            <li class="dark"><a href="recipes.html" title="Pizza"><i class="icon  icon-themeenergy_pizza-slice"></i> <span>Pizza</span></a></li>
                            
                            <li class="medium"><a href="recipes.html" title="Kids"><i class="icon icon-themeenergy_happy"></i> <span>Kids</span></a></li>
                            <li class="dark"><a href="recipes.html" title="Meat"><i class="icon icon-themeenergy_meat"></i> <span>Meat</span></a></li>
                            <li class="light"><a href="recipes.html" title="Snacks"><i class="icon icon-themeenergy_fried-potatoes"></i> <span>Snacks</span></a></li>
                            
                            <li class="dark"><a href="recipes.html" title="Salads"><i class="icon icon-themeenergy_eggplant"></i> <span>Salads</span></a></li>
                            <li class="light"><a href="recipes.html" title="Storage"><i class="icon icon-themeenergy_soup2"></i> <span>Soups</span></a></li>
                            <li class="medium"><a href="recipes.html" title="Vegetarian"><i class="icon icon-themeenergy_plant-symbol"></i> <span>Vegetarian</span></a></li>
                        </ul>
                    </div>
                        
                    <div class="widget">
                        <h3>Tips and tricks</h3>
                        <ul class="articles_latest">
                            <li>
                                <a href="blog_single.html">
                                    <img src="images/img9.jpg" alt="" />
                                    <h6>How to decorate cookies</h6>
                                </a>
                            </li>
                            <li>
                                <a href="blog_single.html">
                                    <img src="images/img10.jpg" alt="" />
                                    <h6>Make your own bread</h6>
                                </a>
                            </li>
                            <li>
                                <a href="blog_single.html">
                                    <img src="images/img11.jpg" alt="" />
                                    <h6>How to make sushi</h6>
                                </a>
                            </li>
                            <li>
                                <a href="blog_single.html">
                                    <img src="images/img12.jpg" alt="" />
                                    <h6>Barbeque party</h6>
                                </a>
                            </li>
                            <li>
                                <a href="blog_single.html">
                                    <img src="images/img8.jpg" alt="" />
                                    <h6>How to make a cheesecake</h6>
                                </a>
                            </li>
                        </ul>
                    </div>
                        
                    <div class="widget members">
                        <h3>Our members</h3>
                        <div id="members-list-options" class="item-options">
                          <a href="#">Newest</a>
                          <a class="selected" href="#">Active</a>
                          <a href="#">Popular</a>
                        </div>
                        <ul class="boxed">
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar1.jpg" alt="" /><span>Kimberly C.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar2.jpg" alt="" /><span>Alex J.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar3.jpg" alt="" /><span>Denise M.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar9.jpg" alt="" /><span>Jason H.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar8.jpg" alt="" /><span>Jennifer W.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar4.jpg" alt="" /><span>Anabelle Q.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar7.jpg" alt="" /><span>Thomas M.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar5.jpg" alt="" /><span>Michelle S.</span></a></div></li>
                            <li><div class="avatar"><a href="my_profile.html"><img src="images/avatar6.jpg" alt="" /><span>Bryan A.</span></a></div></li>
                        </ul>
                    </div>
                        
                    <div class="widget">
                        <h3>Advertisment</h3>
                        <a href="#"><img src="images/advertisment.jpg" alt="" /></a>
                    </div>
                </aside>
            </div>
        </div>
    </main>
    
    <section class="cta">
        <div class="wrap clearfix">
            <a href="http://themeforest.net/item/socialchef-social-recipe-html-template/8568727?ref=themeenergy" class="button big white right">Purchase theme</a>
            <h2>Already convinced? This is a call to action section lorem ipsum dolor sit amet.</h2>
        </div>
    </section>
@endsection

@section('scripts')
    <script src="{{ asset('js/home.js') }}"></script>
@endsection