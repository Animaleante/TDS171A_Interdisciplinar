<aside class="main-sidebar">
    <section class="sidebar">
        <ul class="sidebar-menu" data-widget="tree">
            <li class="header">MAIN NAVIGATION</li>
            <li class="active"><a href="https://adminlte.io/docs"><i class="fa fa-dashboard"></i> <span>Dashboard</span></a></li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>Ingredientes</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="#"><i class="fa fa-circle-o"></i> Listar</a>
                    </li>
                    <li>
                        <a href="#"><i class="fa fa-circle-o"></i> Adicionar</a>
                    </li>
                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-user"></i> <span>Usuários</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
                <ul class="treeview-menu">
                    <li>
                        <a href="{{ route('admin.user.index')}}"><i class="fa fa-circle-o"></i> Listar</a>
                    </li>
                    <li>
                        <a href="{{ route('admin.user.create')}}"><i class="fa fa-circle-o"></i> Adicionar</a>
                    </li>
                </ul>
            </li>
        </ul>
    </section>
</aside>