#ifndef MAINWINDOW_H
#define MAINWINDOW_H

#include <QtWidgets>
#include <RenderPanel.h>

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
   RenderPanel* centralpanel;
   QFileDialog *fd;
   QToolBar * tb;
   QAction *open;
   QAction *zoomIn;
   QAction *zoomOut;
   QAction *panR;
   QAction *panL;
   QAction *panU;
   QAction *panD;
   QAction *vertice;
   QAction *aresta;
   QAction *face;
   QAction *del;
   QAction *vdv;

};


#endif
