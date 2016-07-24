#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QMainWindow>
#include <QtGui>
#include <QFileDialog>
#include <commandqueue.h>
//#include <RenderPanel.h>

class MainWindow : public QMainWindow
{
    Q_OBJECT

public slots:
    void update(void);
    void clicou(QAction* a);

public:
    MainWindow();

private:
   CommandQueue *fila;
   QWidget* centralpanel;
   QFileDialog *fdo;
   QFileDialog *fds;
   QToolBar * tb;
   QAction *open;
   QAction *save;

};


#endif
