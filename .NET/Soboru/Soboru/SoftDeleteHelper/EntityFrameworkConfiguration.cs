using System.Data.Entity;


namespace Soboru.SoftDeleteHelper
{
    public class EntityFrameworkConfiguration : DbConfiguration
    {
        public EntityFrameworkConfiguration()
        {
            AddInterceptor(new SoftDeleteInterceptor());
            AddInterceptor(new CreatedAndUpdatedDateInterceptor());
        }
    }
}