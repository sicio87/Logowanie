package eu.karols.dao;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import eu.karols.bean.Article;

public class ArticleDAO {

	public void addArticleDetails(String articleTitle, String articleText) {
		try {
			// 1. configuring hibernate
			Configuration configuration = new Configuration().configure();

			// 2. create sessionfactory
			SessionFactory sessionFactory = configuration.buildSessionFactory();

			// 3. Get Session object
			Session session = sessionFactory.openSession();

			// 4. Starting Transaction
			Transaction transaction = session.beginTransaction();
			Article article = new Article();
			article.setCreationDate(new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime()));			
			article.setCreationTime(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));			
			article.setArticleTitle(articleTitle);
			article.setArticleText(articleText);
			session.save(article);
			transaction.commit();
			System.out.println("\n\n Article Added \n");

		} catch (HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}

	}

}
