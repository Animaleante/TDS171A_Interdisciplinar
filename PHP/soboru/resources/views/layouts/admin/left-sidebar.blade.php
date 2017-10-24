<aside class="main-sidebar">
    <section class="sidebar">
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            <li class="{{Utils::activeRouteClass('admin.index')}}"><a href="{{route('admin.index')}}"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>

            <li class="treeview {{Utils::activeRouteClass('admin.ingrediente.*')}}">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Ingredientes</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="{{Utils::activeRouteClass('admin.ingrediente.index')}}">
                        <a href="#"><i class="fa fa-circle-o"></i> Listar</a>
                    </li>
                    <li class="{{Utils::activeRouteClass('admin.ingrediente.create')}}">
                        <a href="#"><i class="fa fa-circle-o"></i> Adicionar</a>
                    </li>
                </ul>
            </li>

            <li class="treeview {{Utils::activeRouteClass('admin.user.*')}}">
                <a href="#">
                    <i class="fa fa-user"></i> <span>Usuários</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li class="{{Utils::activeRouteClass('admin.user.index')}}">
                        <a href="{{ route('admin.user.index')}}"><i class="fa fa-circle-o"></i> Listar</a>
                    </li>
                    <li class="{{Utils::activeRouteClass('admin.user.create')}}">
                        <a href="{{ route('admin.user.create')}}"><i class="fa fa-circle-o"></i> Adicionar</a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
</aside>