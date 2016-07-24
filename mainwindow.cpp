#include "mainwindow.h"
#include "ui_mainwindow.h"
//#include <MainWindow.h>
#include <QPainter>
#include <Qt>
#include <CommandQueue.h>


MainWindow::MainWindow(){
    QIcon op(":open");
//    QIcon sv(":save");

    int w = 700;
    int h = 700;

    fila = new CommandQueue();
    centralpanel = new QWidget;
    setCentralWidget(centralpanel);

    tb = new QToolBar("Tool Bar", this);
    fdo = new QFileDialog(this, Qt::Window);
   // fds = new QFileDialog(this, Qt::Window);
    fdo->setDirectory("..");
    fdo->setNameFilter("*.txt");

//    fds->setDirectory("..");
//    fds->setNameFilter("*.png");


    connect(tb, SIGNAL(actionTriggered( QAction * )), this, SLOT(clicou(QAction*)));
    connect(fdo, SIGNAL(fileSelected(const QString &)), centralpanel, SLOT(recebeArquivo(const QString &)));
    //connect(fds, SIGNAL(fileSelected(const QString &)), centralpanel, SLOT(salvaArquivo(const QString &)));


    open = tb->addAction(op, "");
   // save = tb->addAction(sv, "");

    addToolBar(Qt::LeftToolBarArea, tb);

    connect(centralpanel, SIGNAL(atualizaMain()), this, SLOT(update()));

    setWindowTitle("Half-Edge T3");
    setFixedSize(w, h);
}

void MainWindow::clicou(QAction* a)
{
    if(a == open)
    {
        fdo->setAcceptMode(QFileDialog::AcceptOpen);
        fdo->open();
    }

//    if(a == save)
//    {
//        fds->setAcceptMode(QFileDialog::AcceptSave);
//        fds->open();
//    }
}

void MainWindow::update(void)
{
    repaint();
}


//MainWindow::~MainWindow()
//{
//    delete ui;
//}
