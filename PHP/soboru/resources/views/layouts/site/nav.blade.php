<header class="head" role="banner">
    <!--wrap-->
    <div class="wrap clearfix">
        <a href="/" title="SocialChef" class="logo"><img src="/images/ico/logo.png" alt="SocialChef logo" /></a>
        
        <nav class="main-nav" role="navigation" id="menu">
            <ul>
                <li class="current-menu-item">
                    <a href="/" title="Home"><span>Home</span></a>
                </li>
                <li>
                    <a href="/receitas" title="Recipes"><span>Receitas</span></a>
                    {{-- <ul>
                        <li>
                            <a href="recipes2.html" title="Recipes 2">Recipes 2</a>
                        </li>
                        <li>
                            <a href="recipe.html" title="Recipe">Recipe</a>
                        </li>
                    </ul> --}}
                </li>
                {{-- <li>
                    <a href="blog.html" title="Blog"><span>Blog</span></a>
                    <ul>
                        <li>
                            <a href="blog_single.html" title="Blog post">Blog post</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" title="Pages"><span>Pages</span></a>
                    <ul>
                        <li><a href="left_sidebar.html" title="Left sidebar page">Left sidebar page</a></li>
                        <li><a href="right_sidebar.html" title="Right sidebar page">Right sidebar page</a></li>
                        <li><a href="two_sidebars.html" title="Both sidebars page">Both sidebars page</a></li>
                        <li><a href="full_width.html" title="Full width page">Full width page</a></li>
                        <li><a href="login.html" title="Login page">Login page</a></li><li><a href="register.html" title="Register page">Register page</a></li>
                        <li><a href="error404.html" title="Error page">Error page</a></li>
                    </ul>
                </li>
                <li>
                    <a href="#" title="Features"><span>Features</span></a>
                    <ul>
                        <li><a href="icons.html" title="Icons">Icons</a></li>
                        <li><a href="grid.html" title="Grid">Grid</a></li>
                        <li><a href="shortcodes.html" title="Shortcodes">Shortcodes</a></li>
                        <li><a href="pricing.html" title="Pricing tables">Pricing tables</a></li>
                    </ul>
                </li>
                <li>
                    <a href="contact.html" title="Contact"><span>Contact</span></a>
                </li>
                <li>
                    <a href="http://themeforest.net/item/socialchef-social-recipe-html-template/8568727?ref=themeenergy" title="Buy now"><span>Buy now</span></a>
                </li> --}}
            </ul>
        </nav>
        
        <nav class="user-nav" role="navigation">
            <ul>
                {{-- <li class="light current-menu-item"> --}}
                <li class="light">
                    <a href="#" title="Search for recipes">
                        <i class="icon icon-themeenergy_search"></i> <span>Procurar receitas</span>
                    </a>
                </li>
                <li class="medium">
                    <a href="#" title="My account">
                        <i class="icon icon-themeenergy_chef-hat"></i> <span>Minha conta</span>
                    </a>
                </li>
                <li class="dark">
                    <a href="{{ url('receitas/create')}}" title="Submit a recipe">
                        <i class="icon icon-themeenergy_fork-spoon"></i> <span>Enviar receita</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</header>