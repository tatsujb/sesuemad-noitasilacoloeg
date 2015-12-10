package Poubelle;

/**
 * Created by Fabienne_2 on 10/12/2015.
 */
public class DonneesBean implements BeanFactoryAware{
        private BeanFactory factory;

        // BeanFactoryAware setter (called by Spring during bean instantiation)
        public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
            this.factory = beanFactory;
        }

        public void close(){
            // do clean-up
        }
}
