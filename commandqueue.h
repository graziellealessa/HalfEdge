#ifndef _COMMANDQUEUE_H
#define	_COMMANDQUEUE_H

#define MAXCOMMANDS  100

#include <QObject>
#include <QMutex>

enum Commands{
    NENHUM,
    SELECT,
    RENDER
};

typedef struct _ExCom{
    Commands cmd;
    int x;
    int y;
}ExCom;

class CommandQueue : public QObject
{
    Q_OBJECT
public:
    CommandQueue();

    ExCom consome();
    void produz(Commands cmd, int x = 0, int y = 0);

private:
    ExCom cmdList[MAXCOMMANDS];
    QMutex m;
    int indCon;
    int indPro;

};

#endif	/* _COMMANDQUEUE_H */

